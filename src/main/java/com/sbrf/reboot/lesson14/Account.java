package com.sbrf.reboot.lesson14;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class Account {
    private final BigDecimal balance;
    private final String currency;
    private final LocalDate createDate;
}
