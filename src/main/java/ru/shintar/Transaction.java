package ru.shintar;

import java.util.List;
import java.util.Random;

public class Transaction implements Runnable {
    final static private Counter counter = new Counter(0);
    final private List<Account> accounts;

    public Transaction(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void run() {

        Random random = new Random();
        int numberOfTransactions = 30;

        AccountService controller = new AccountService();

        while (counter.getNumber() < numberOfTransactions) {

            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (counter) {
                if (counter.getNumber() >= numberOfTransactions) {
                    break;
                }
                counter.increase();
            }

            int transferFromIndex = random.nextInt(accounts.size());
            int transferToIndex = random.nextInt(accounts.size());
            int amount = random.nextInt(1000);

            controller.transfer(accounts.get(transferFromIndex), accounts.get(transferToIndex), amount);
        }
    }
}
