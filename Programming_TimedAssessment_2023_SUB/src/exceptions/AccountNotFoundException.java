package exceptions;

public class AccountNotFoundException extends RuntimeException {

    // Task 0.1: For cases where the provided accountID can't be found in the list being searched, a not found message is returned.
    public AccountNotFoundException(int accountID) {
        super("Account not found with accountID: " + accountID);
    }
}
