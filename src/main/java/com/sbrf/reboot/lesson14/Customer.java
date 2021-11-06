package com.sbrf.reboot.lesson14;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Customer {
    private final int age;
    private final String name;
    private final List<Account> accounts;
}
