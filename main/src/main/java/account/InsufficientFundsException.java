package account;

public class InsufficientFundsException extends Exception {

    private final double amount;

    public InsufficientFundsException(double amt) {
        this.amount = amt;
    }

    public double getAmount() {
        return amount;
    }
}