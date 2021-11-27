package com.sbrf.reboot.lesson16;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class Client {
    private final String name;

    private final Set<Account> accounts;
}
