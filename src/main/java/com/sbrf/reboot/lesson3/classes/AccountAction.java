package com.sbrf.reboot.lesson3.classes;

public interface AccountAction {
    boolean isAccountExist(long clientId, Account account);

    int getNumberOfClientAccounts(long clientId);
}
