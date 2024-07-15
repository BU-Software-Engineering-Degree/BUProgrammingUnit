package exceptions;

public class InsufficientFundsException extends RuntimeException {

    // Task 0.2: For cases where the provided withdrawal amount can't be taken due to it being greater than available amount
    // in the bank account being searched, an insufficient funds message is returned.
    public InsufficientFundsException(double availableBalance, double withdrawalAmount) {
        super("Insufficient funds for this withdrawal. (Available Balance:" + availableBalance + ", Amount Requested:" + withdrawalAmount + ")");
    }
}
