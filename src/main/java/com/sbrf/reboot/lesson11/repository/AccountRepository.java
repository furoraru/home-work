package com.sbrf.reboot.lesson11.repository;

import com.sbrf.reboot.lesson11.classes.Account;

import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long clientId);
}
