package com.sbrf.reboot.lesson16.config;

import lombok.RequiredArgsConstructor;
import com.sbrf.reboot.lesson16.Client;
import com.sbrf.reboot.lesson16.Account;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;
import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final Environment env;

    @Bean
    public Account getAccount() {
        return new Account(env.getProperty("account.number"));
    }

    @Bean
    public Client getClient() {
        Set<Account> accounts = new HashSet<>();
        accounts.add(getAccount());
        return new Client(env.getProperty("client.name"), accounts);
    }
}