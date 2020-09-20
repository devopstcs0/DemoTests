import account.Account;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//Here im using Junit framework for unit test cases and seeing up using Before and cass classes
public class AccountTest {

    private static Account account;
    private ExpectedException thrown;

    @BeforeClass
    public static void setUpClass() {
        account = new Account(100);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    // In this test cases im validating the withdraw method
    // 'if' block to validate if no founds are available
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawWithNoFunds() throws IllegalArgumentException {
        double amount = 1;
        Account account = new Account();
        account.Withdraw(amount);
        double balance = account.getBalance();
        assertEquals(-amount, balance);
    }

    // In this test cases im validating the withdraw method
    // to validate if amount exceed the balance asserting the balance is correct
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawExceedBalance() throws IllegalArgumentException {
        double amount = 1.50;
        Account account = new Account();
        account.Withdraw(amount);
        double balance = account.getBalance();
        assertEquals(0.0, balance);
    }

    // In this test cases im validating the withdraw method and balance is matching the expected
    @Test
    public void testWithdrawBalance() {
        double amount = 90;
        account.Withdraw(amount);
        double balance = account.getBalance();
        assertEquals(10.0, balance);
    }

    // In this test cases im validating the withdraw method amount exceed balance
    // and exception is thrown and asserting the exception message matches.
    @Test
    public void testWithdrawException(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                            double amount = 500;
                            account.Withdraw(amount);
                        }
        );
        assertEquals("Withdrawal exceeds balance!", exception.getMessage());
    }
}
