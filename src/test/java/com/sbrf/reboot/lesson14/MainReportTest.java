package com.sbrf.reboot.lesson14;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.stream.Stream;

public class MainReportTest {
    public static final int MIN_AGE = 18;
    public static final int MAX_AGE = 30;

    public static final LocalDate START_DATE = LocalDate.of(2021, Month.JULY, 1);
    public static final LocalDate END_DATE = LocalDate.of(2021, Month.AUGUST, 1);

    MainReport mainReport;

    Customer customer1;
    Customer customer2;
    Customer customer3;

    @BeforeEach
    void setUp() {
        mainReport = new MainReport();

        Account account1 = new Account(BigDecimal.valueOf(10), "RUB", LocalDate.of(2021, Month.JUNE, 29));
        Account account2 = new Account(BigDecimal.valueOf(20), "EUR", LocalDate.of(2021, Month.JULY, 12));
        Account account3 = new Account(BigDecimal.valueOf(30), "RUB", LocalDate.of(2021, Month.AUGUST, 1));
        Account account4 = new Account(BigDecimal.valueOf(40), "EUR", LocalDate.of(2021, Month.JULY, 1));
        Account account5 = new Account(BigDecimal.valueOf(50), "RUB", LocalDate.of(2021, Month.JULY, 1));
        Account account6 = new Account(BigDecimal.valueOf(100), "RUB", LocalDate.of(2021, Month.AUGUST, 1));

        customer1 = new Customer(18, "name1", Arrays.asList(account1, account2));
        customer2 = new Customer(30, "name2", Arrays.asList(account3, account4, account5));
        customer3 = new Customer(41, "name3", Arrays.asList(account6));
    }

    @SneakyThrows
    @Test
    void totalsWithCompletableFutureTest() {
        BigDecimal sum = mainReport.getTotalsWithCompletableFuture(Stream.of(customer1, customer2, customer3), "RUB", MIN_AGE, MAX_AGE, START_DATE, END_DATE);
        Assertions.assertEquals(BigDecimal.valueOf(80), sum);
    }

    @SneakyThrows
    @Test
    void totalsWithReactTest() {
        BigDecimal sum = mainReport.getTotalsWithReact(Stream.of(customer1, customer2, customer3), "RUB", MIN_AGE, MAX_AGE, START_DATE, END_DATE);
        Assertions.assertEquals(BigDecimal.valueOf(80), sum);
    }
}
