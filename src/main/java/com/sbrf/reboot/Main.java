package com.sbrf.reboot;

import com.sbrf.reboot.lesson16.Account;
import com.sbrf.reboot.lesson16.Client;
import org.springframework.context.ApplicationContext;
import com.sbrf.reboot.lesson16.config.ApplicationConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        getClientContextFromXML();
        getAccountContextFromXML();
        getClientContextFromJavaBasedConfig();
        getAccountContextFromJavaBasedConfig();
    }

    public static Client getClientContextFromXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        return context.getBean(Client.class);
    }

    public static Client getClientContextFromJavaBasedConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        return context.getBean(Client.class);
    }

    public static Account getAccountContextFromXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        return context.getBean(Account.class);
    }

    public static Account getAccountContextFromJavaBasedConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        return context.getBean(Account.class);
    }
}
