import account.Account;
import account.InsufficientFundsException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;


//Here im using Junit framework for unit test cases and seeing up using Before and cass classes
public class AccountTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    // In this test cases im validating the withdraw method
    // 'if' block to validate if no founds are available
    @Test(expected= InsufficientFundsException.class)
    public void testWithdrawWithNoFunds() throws InsufficientFundsException {
        double amount = 1;
        Account account = new Account();
        account.Withdraw(amount);
        double balance = account.getBalance();
        assertEquals(-amount, balance);
    }

    // In this test cases im validating the withdraw method
    // 'else' block to validate if amount exceed the balance and log for error message
    @Test(expected=InsufficientFundsException.class)
    public void testWithdrawExceedBalance() throws InsufficientFundsException {
        double amount = 1.50;
        Account account = new Account();
        account.Withdraw(amount);
        double balance = account.getBalance();
        assertEquals(amount, balance);
    }
}
