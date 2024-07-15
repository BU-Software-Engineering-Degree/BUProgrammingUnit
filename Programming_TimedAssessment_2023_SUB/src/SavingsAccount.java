import java.text.DecimalFormat;

public class SavingsAccount extends BankAccount {

    // Task 2.1: The variable specific to the "SavingsAccount" class.
    private double interestRate;

    // Task 2.2: For when the "SavingsAccount" class is instantiated the values provided are given to the local
    // versions of those variables.
    public SavingsAccount(int accountID, double currentBalance, double interestRate) {
        super(accountID, currentBalance);
        this.interestRate = interestRate;
    }

    // Task 2.3: Returning the interest of each bank account when requested.
    public double getInterestRate(){
        return this.interestRate;
    }

    // Task 2.4: The standard representation of percentages is by using "%" therefore this method is to format all
    // interest rates to be more readable. Example: 0.05 becomes 5%.
    public String getFormattedInterestRate() {

        return (interestRate*100) + "%";
    }

    // Task 2.5: Sets the interest rate of the current bank account while also checking it's within the parameters
    // ie no more than 100% and no less than 0%.
    public void setInterestRate(double interestRate) throws IllegalArgumentException {
        if (interestRate < 0){
            throw new IllegalArgumentException("Interest Rate cannot be less than 0%!");
        }
        else if (interestRate > 1.0) {
            throw new IllegalArgumentException("Interest Rate cannot be greater than 100%!");
        }
        else {
            this.interestRate = interestRate;
        }
    }

    // Task 2.6: Calculates the annual interest made and formats the numbers into a currency.
    public String getEstimatedAnnualReturn(){
        double annualInterest = getCurrentBalance() * interestRate;

        String pattern = "£###,###,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        return decimalFormat.format(annualInterest);
    }

    // Task 2.7: Calculates the monthly interest made and formats the numbers into a currency.
    public String getEstimatedMonthlyReturn(){
        double monthlyInterest = (getCurrentBalance() * interestRate) / 12;

        String pattern = "£###,###,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        return decimalFormat.format(monthlyInterest);
    }

    // Task 2.8: This method takes the formatted strings created from Task 2.6 & 2.7 and formats them into one big string.
    @Override
    public String toString() {

        return "A/C No: " + getFormattedAccountNumber() + ", Balance: " + getFormattedCurrentBalance() + ", Interest Rate: " + getFormattedInterestRate();
    }
}
