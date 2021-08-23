package com.sbrf.reboot.lesson3.service;

import com.sbrf.reboot.lesson3.classes.Account;
import com.sbrf.reboot.lesson3.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);

        accountService = new AccountService(accountRepository);
    }

    @Test
    void accountExist() {
        Account account = new Account("ACC1234NUM");
        Set<Account> accounts = new HashSet();
        accounts.add(account);

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertTrue(accountService.isAccountExist(1L, account));
    }

    @Test
    void accountNotExist() {
        Set<Account> accounts = new HashSet();
        accounts.add(new Account("ACC1234NUM"));

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertFalse(accountService.isAccountExist(1L, new Account("ACC456NUM")));
    }

    @Test
    void accountNumber() {
        Set<Account> accounts = new HashSet();

        Account account1 = new Account("ACC1234NUM");
        Account account2 = new Account("ACC1234NUM");

        accounts.add(account1);
        accounts.add(account2);

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertEquals(2, accountService.getNumberOfClientAccounts(1L));
    }
}