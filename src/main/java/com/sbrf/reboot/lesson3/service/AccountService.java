package com.sbrf.reboot.lesson3.service;

import com.sbrf.reboot.lesson3.classes.Account;
import com.sbrf.reboot.lesson3.classes.AccountAction;
import com.sbrf.reboot.lesson3.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.Set;

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
}
