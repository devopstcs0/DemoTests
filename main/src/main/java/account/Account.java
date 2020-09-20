package account;

public class Account {

    private double m_balance;

    public Account(double bal) {
        this.m_balance = bal;
    }

    public Account() {
        m_balance = 0.0;
    }

    public double getBalance() {
        return m_balance;
    }

    public void Withdraw(double amount) {

         if(m_balance >= amount) {
            m_balance -= amount;
        }else {
             throw new IllegalArgumentException("Withdrawal exceeds balance!");
         }
    }

    public static void main (String[] args) {
        Account ac = new Account(100);
        try {
            ac.Withdraw(100);
        }catch(IllegalArgumentException e) {
           System.out.println("Balance is :" +ac.getBalance() );
        }
    }
}