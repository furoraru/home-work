package com.sbrf.reboot.lesson3.service;

import com.sbrf.reboot.lesson3.classes.Account;
import com.sbrf.reboot.lesson3.repository.AccountRepository;

import java.util.Set;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(long clientId, Account account) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.contains(account);
    }

}
