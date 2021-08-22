package com.sbrf.reboot.lesson3.repository;

import com.sbrf.reboot.lesson3.classes.Account;

import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long clientId);
}
