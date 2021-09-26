package com.sbrf.reboot.lesson7.classes;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
    @Getter
    private long id;

    @Getter
    private LocalDate createDate;

    @Getter
    private BigDecimal balance;

    private Account() {

    }

    public static Builder builder() {
        return new Account().new Builder();
    }

    public class Builder {

        public Builder id(long id) {
            Account.this.id = id;
            return this;
        }

        public Builder createDate(LocalDate date) {
            Account.this.createDate = date;
            return this;
        }

        public Builder balance(BigDecimal balance) {
            Account.this.balance = balance;
            return this;
        }

        public Account build() {
            return Account.this;
        }
    }
}

