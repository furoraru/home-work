package com.sbrf.reboot.lesson11.classes;

import java.time.LocalDate;
import java.util.Set;

public interface AccountAction {
    boolean isAccountExist(long clientId, Account account);

    int getNumberOfClientAccounts(long clientId);

    Account getMaxAccountBalance(long clientId);

    Set getAllAccountsByDateMoreThen(long l, LocalDate minusDays);
}