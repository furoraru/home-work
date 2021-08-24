package com.sbrf.reboot.lesson4.service;

import com.sbrf.reboot.lesson4.classes.Account;
import com.sbrf.reboot.lesson4.classes.AccountAction;
import com.sbrf.reboot.lesson4.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.Set;

@RequiredArgsConstructor
public class AccountService implements AccountAction {
    private final AccountRepository accountRepository;

    public boolean isAccountExist(long clientId, Account account) throws IOException {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.contains(account);
    }

    public int getNumberOfClientAccounts(long clientId) throws IOException {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.size();
    }
}
