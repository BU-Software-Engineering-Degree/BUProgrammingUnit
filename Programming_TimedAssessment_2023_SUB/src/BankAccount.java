import exceptions.InsufficientFundsException;
import java.text.DecimalFormat;

public class BankAccount {

    // Task 1.1: The key variables of the "BankAccount" class, these hold the account ID and current balance of each
    // existing bank accounts.
    private final int accountID;
    private double currentBalance;

    // Task 1.2: For when the "BankAccount" class is instantiated the values provided are given to the local
    // versions of those variables.
    public BankAccount(int accountID, double currentBalance) {
        this.accountID = accountID;
        this.currentBalance = currentBalance;
    }

    // Task 1.3: Returning the account ID and current balance of each bank account when requested.
    public int getAccountID(){
        return this.accountID;
    }

    public double getCurrentBalance(){
        return this.currentBalance;
    }

    // Task 1.4: A method to add the given amount to the current balance of the bank account being used.
    // Where the deposited amount has to be more than £0 otherwise an error message is "thrown".
    public void deposit(double depositAmount) throws IllegalArgumentException {
        if (depositAmount <= 0){
            throw new IllegalArgumentException("Deposit amount must be greater than 0.00!");
        }
        else {
            this.currentBalance += depositAmount;
        }
    }

    // Task 1.5: A method to subtract the given amount to the current balance of the bank account being used.
    // Where the withdrawal amount has to be more than £0 otherwise an error message is "thrown".
    public void withdraw(double withdrawalAmount) throws IllegalArgumentException, InsufficientFundsException {
        if (withdrawalAmount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0.00!");
        }
        else if (withdrawalAmount > this.currentBalance) {
            throw new InsufficientFundsException(this.currentBalance, withdrawalAmount);
        }
        else {
            this.currentBalance -= withdrawalAmount;
        }
    }

    // Task 1.6: A standard bank account number has 8 digits therefore this method checks for that case and if there's
    // less than 8 digits, leading 0s are added. Example: 192 becomes 00000192.
    public String getFormattedAccountNumber() {
        StringBuilder accountIDStr = new StringBuilder("" + this.accountID);
        int accountIDLength = accountIDStr.length();
        int leadingZerosToAdd= 8 - accountIDLength;

        if (accountIDLength != 8){
            for (int i = 0; i < leadingZerosToAdd; i++){
                accountIDStr.insert(0, "0");
            }
        }

        return accountIDStr.toString();
    }

    // Task 1.7: The standard presentation of money is £000.00 therefore this method formats the current balance into
    // the "standard". Example: 4360.5 becomes £4,360.50.
    public String getFormattedCurrentBalance(){
        String pattern = "£###,###,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        return decimalFormat.format(this.currentBalance);
    }

    // Task 1.8: This method takes the formatted strings created from Task 1.6 & 1.7 and formats them into one big string.
    @Override
    public String toString() {

        return "A/C No: " + getFormattedAccountNumber() + ", Balance: " + getFormattedCurrentBalance();
    }

    /* =======================================
        DO NOT EDIT OR REMOVE THE BELOW CODE!
    ======================================= */

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BankAccount){
            return (((BankAccount) obj).accountID == accountID) && ((BankAccount) obj).currentBalance == currentBalance;
        }else{
            return super.equals(obj);
        }
    }
}
