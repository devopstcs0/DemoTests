package account;

public class Account {

    private double m_balance;

    public Account(double bal) {
        this.m_balance = bal;
    }

    public Account() {
        m_balance = 0;
    }

    public double getBalance() {
        return m_balance;
    }

    public void Withdraw(double amount) throws InsufficientFundsException {

         if(m_balance >= amount) {
            m_balance -= amount;
        }else {
             System.out.println("Withdrawal exceeds balance!");
             throw new InsufficientFundsException(amount);
         }
    }

    public static void main (String[] args) {
        Account ac = new Account(100);
        try {
            ac.Withdraw(100);
        }catch(InsufficientFundsException e) {
           System.out.println("Balance is :" +ac.getBalance() );
        }
    }
}