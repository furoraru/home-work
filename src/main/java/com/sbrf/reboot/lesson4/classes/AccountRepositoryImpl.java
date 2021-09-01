package com.sbrf.reboot.lesson4.classes;

import com.sbrf.reboot.lesson4.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private final String accountsPath;

    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(accountsPath));

        Set<Account> accounts = new HashSet<>();
        String numberFromFile;
        long clientIdFromFile;
        String currentLine = null;

        try {
            currentLine = reader.readLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        while (currentLine != null) {
            if (currentLine.contains("clientId")) {
                currentLine = currentLine.substring(currentLine.indexOf(":") + 1);
                currentLine = currentLine.substring(0, currentLine.indexOf(","));
                clientIdFromFile = Long.parseLong(currentLine.trim());

                currentLine = reader.readLine();
                if (clientIdFromFile == clientId) {
                    currentLine = currentLine.substring(currentLine.indexOf(":") + 1);
                    currentLine = currentLine.substring(currentLine.indexOf("\"") + 1);
                    currentLine = currentLine.substring(0, currentLine.indexOf("\""));
                    numberFromFile = currentLine;
                    accounts.add(new Account(numberFromFile));
                }
            }
            currentLine = reader.readLine();
        }
        try {
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return accounts;
    }

    @Override
    public void updateClientNumber(long clientId, String number) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(accountsPath));

        long clientIdFromFile;
        StringBuilder newAccountsList = new StringBuilder();
        boolean isNoUpdatedNumbers = true;
        String currentLine = null;

        try {
            currentLine = reader.readLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        while (currentLine != null) {
            newAccountsList.append(currentLine).append("\n");
            if (currentLine.contains("clientId") && isNoUpdatedNumbers) {
                currentLine = currentLine.substring(currentLine.indexOf(":") + 1);
                currentLine = currentLine.substring(0, currentLine.indexOf(","));
                clientIdFromFile = Long.parseLong(currentLine.trim());

                currentLine = reader.readLine();
                if (clientIdFromFile == clientId) {
                    newAccountsList.append("\"number\": \"").append(number).append("\"\n");
                    isNoUpdatedNumbers = false;
                } else {
                    newAccountsList.append(currentLine).append("\n");
                }
            }
            currentLine = reader.readLine();
        }
        try {
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(accountsPath));
        writer.append(newAccountsList);
        writer.close();

    }
}
