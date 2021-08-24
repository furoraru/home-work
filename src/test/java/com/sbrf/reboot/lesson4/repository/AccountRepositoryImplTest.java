package com.sbrf.reboot.lesson4.repository;

import com.sbrf.reboot.lesson4.classes.Account;
import com.sbrf.reboot.lesson4.classes.AccountRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {

    AccountRepository accountRepository;

    @Test
    void onlyPersonalAccounts() throws IOException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);
        ArrayList<String> accounts = new ArrayList<String>() {{
            add("2-ACCNUM");
            add("1-ACCNUM");
            add("4-ACC1NUM");
        }};

        List<String> allAccountsList = allAccountsByClientId.stream().map(Account::getNumber).collect(Collectors.toList());
        assertTrue(accounts.containsAll(allAccountsList));
    }

    @Test
    void successGetAllAccountsByClientId() throws IOException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(2);

        List<String> allAccountsList = allAccountsByClientId.stream().map(Account::getNumber).collect(Collectors.toList());
        assertTrue(allAccountsList.contains("5-ACC1NUM"));
    }

    @Test
    void failGetAllAccountsByClientId() {
        accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class, () -> {
            accountRepository.getAllAccountsByClientId(1L);
        });
    }

    @Test
    void updateAccounts() throws IOException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/AccountsForUpdate.txt");
        Set<Account> accounts1 = accountRepository.getAllAccountsByClientId(1);
        Set<Account> accounts2 = accountRepository.getAllAccountsByClientId(1);

        List<String> list1 = accounts1.stream().map(Account::getNumber).collect(Collectors.toList());
        List<String> list2 = accounts2.stream().map(Account::getNumber).collect(Collectors.toList());

        assertTrue(list1.containsAll(list2));

        accountRepository.updateClientNumber(1, "who-am-i");
        accounts1 = accountRepository.getAllAccountsByClientId(1);
        list1 = accounts1.stream().map(Account::getNumber).collect(Collectors.toList());

        assertFalse(list1.containsAll(list2));

    }

}