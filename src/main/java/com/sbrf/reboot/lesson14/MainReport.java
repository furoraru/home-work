package com.sbrf.reboot.lesson14;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainReport {
    public static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    public BigDecimal getTotalsWithCompletableFuture(
            Stream<Customer> customers, String currency, int minAge, int maxAge, LocalDate startDate, LocalDate endDate
    ) throws ExecutionException, InterruptedException {
        List<CompletableFuture<BigDecimal>> completableFutures =
                customers
                        .filter(customer -> customer.getAge() >= minAge && customer.getAge() <= maxAge)
                        .map(Customer::getAccounts)
                        .map(accounts -> CompletableFuture.supplyAsync(
                                () -> accounts
                                        .stream()
                                        .filter(account ->
                                                (account.getCreateDate().isAfter(startDate) || account.getCreateDate().isEqual(startDate))
                                                        && (account.getCreateDate().isBefore(endDate) || account.getCreateDate().isEqual(endDate))
                                                        && account.getCurrency().equals(currency))
                                        .map(Account::getBalance)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add),
                                Executors.newFixedThreadPool(AVAILABLE_PROCESSORS)
                        ))
                        .collect(Collectors.toList());

        return CompletableFuture
                .allOf(completableFutures.toArray(new CompletableFuture[0]))
                .thenApply(feature -> completableFutures
                        .stream()
                        .map(CompletableFuture::join)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .get();
    }

    public BigDecimal getTotalsWithReact(
            Stream<Customer> customers, String currency, int minAge, int maxAge, LocalDate startDate, LocalDate endDate
    ) throws ExecutionException, InterruptedException {
        return customers
                .filter(customer -> customer.getAge() >= minAge && customer.getAge() <= maxAge)
                .map(Customer::getAccounts)
                .map(accounts -> Flux
                        .fromStream(accounts.stream())
                        .subscribeOn(Schedulers.newParallel("parallel", AVAILABLE_PROCESSORS))
                        .filter(account ->
                                (account.getCreateDate().isAfter(startDate) || account.getCreateDate().isEqual(startDate))
                                        && (account.getCreateDate().isBefore(endDate) || account.getCreateDate().isEqual(endDate))
                                        && account.getCurrency().equals(currency))
                        .map(Account::getBalance)
                )
                .reduce(Flux.empty(), Flux::merge)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .toFuture()
                .get();
    }
}
