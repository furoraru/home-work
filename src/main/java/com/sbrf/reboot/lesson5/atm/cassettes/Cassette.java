package com.sbrf.reboot.lesson5.atm.cassettes;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class Cassette<Banknote> {
    private final ArrayList<Banknote> banknotes;

    public int getCountBanknotes() {
        return banknotes.size();
    }
}
