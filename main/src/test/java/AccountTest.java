import account.Account;
import account.InsufficientFundsException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AccountTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test(expected= InsufficientFundsException.class)
    public void testWithdrawWithNoFunds() throws InsufficientFundsException {
        double amount = 1;
        Account instance = new Account();
        instance.Withdraw(amount);
        double balance = instance.getBalance();
        assertEquals(-amount, balance);
    }

    @Test(expected=InsufficientFundsException.class)
    public void testWithdrawExceedBalance() throws InsufficientFundsException {
        double amount = 1.50;
        Account instance = new Account();
        instance.Withdraw(amount);
        double balance = instance.getBalance();
        assertEquals(amount, balance);
    }
}
