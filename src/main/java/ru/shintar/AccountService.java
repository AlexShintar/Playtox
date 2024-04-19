package ru.shintar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    public boolean transfer(Account from, Account to, int amount) {

        synchronized (from) {
            int newBalance = from.getMoney() - amount;

            if (newBalance < 0) {
                logger.warn("Transaction error, not enough money in account id:" + from.getId());
                return false;
            }
            from.setMoney(newBalance);
        }
        synchronized (to) {
            to.setMoney(to.getMoney() + amount);
            logger.info("The transaction is successful.\nNew balance on accounts: " + from.getId() + "="
                    + from.getMoney() + "\n" + to.getId() + "=" + to.getMoney());
        }
        return true;
    }
}
