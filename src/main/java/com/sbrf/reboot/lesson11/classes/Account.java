package com.sbrf.reboot.lesson11.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
    private String accountId;

    @Getter
    private long clientId;

    @Getter
    private LocalDate createDate;

    @Getter
    private long id;

    @Getter
    private BigDecimal balance;

    public Account(String accountId) {
        this.accountId = accountId;
    }

    private Account() {

    }

    public static Account.Builder builder() {
        return new Account().new Builder();
    }

    public class Builder {

        public Account.Builder clientId(long clientId) {
            Account.this.clientId = clientId;
            return this;
        }

        public Account.Builder id(long id) {
            Account.this.id = id;
            return this;
        }

        public Account.Builder createDate(LocalDate date) {
            Account.this.createDate = date;
            return this;
        }

        public Account.Builder balance(BigDecimal balance) {
            Account.this.balance = balance;
            return this;
        }

        public Account build() {
            return Account.this;
        }
    }
}