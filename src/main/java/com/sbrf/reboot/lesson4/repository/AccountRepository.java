package com.sbrf.reboot.lesson4.repository;

import com.sbrf.reboot.lesson4.classes.Account;

import java.io.IOException;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long clientId) throws IOException;

    void updateClientNumber(long clientId, String number) throws IOException;
}
