package ru.shintar;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int numberOfAccounts = 4;
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < numberOfAccounts; i++) {
            accounts.add(new Account(String.valueOf(accounts.size()), 10000));
        }
        int numberOfThreads = 4;

        Thread[] thread = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            thread[i] = new Thread(new Transaction(accounts));
            thread[i].start();
        }
    }
}