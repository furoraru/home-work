package com.sbrf.reboot.lesson4.classes;

import com.sbrf.reboot.lesson4.classes.Account;

import java.io.IOException;

public interface AccountAction {
    boolean isAccountExist(long clientId, Account account) throws IOException;

    int getNumberOfClientAccounts(long clientId) throws IOException;
}
