package com.sbrf.reboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class MainTest {
    @Test
    void getClientContextFromXML() {
        assertNotNull(Main.getClientContextFromXML());
    }

    @Test
    void getAccountContextFromXML() {
        assertNotNull(Main.getAccountContextFromXML());
    }

    @Test
    void getClientContextFromJavaBasedConfig() {
        assertNotNull(Main.getClientContextFromJavaBasedConfig());
    }

    @Test
    void getAccountContextFromJavaBasedConfig() {
        assertNotNull(Main.getAccountContextFromJavaBasedConfig());
    }

    @Test
    void contextXmlNotEqualBased1() {
        assertNotSame(Main.getClientContextFromXML(), Main.getClientContextFromJavaBasedConfig());
    }

    @Test
    void contextXmlNotEqualBased2() {
        assertNotSame(Main.getAccountContextFromXML(), Main.getAccountContextFromJavaBasedConfig());
    }

}