package com.sbrf.reboot.lesson11.service;

import com.sbrf.reboot.lesson11.classes.Account;
import com.sbrf.reboot.lesson11.classes.AccountAction;
import com.sbrf.reboot.lesson11.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AccountService implements AccountAction {
    private final AccountRepository accountRepository;

    public boolean isAccountExist(long clientId, Account account) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.contains(account);
    }

    public int getNumberOfClientAccounts(long clientId) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.size();
    }

    public Account getMaxAccountBalance(long clientId) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.stream()
                .max(Comparator.comparing(Account::getBalance))
                .get();
    }

    public Set getAllAccountsByDateMoreThen(long clientId, LocalDate minusDays) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.stream()
                .filter(Account -> Account.getCreateDate().isAfter(minusDays) || Account.getCreateDate().isEqual(minusDays))
                .collect(Collectors.toSet());
    }
}