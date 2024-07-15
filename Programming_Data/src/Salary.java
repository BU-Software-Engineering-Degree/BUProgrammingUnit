import java.text.DecimalFormat;

/**
 * Salary class
 * This class contains tasks about calculating salaries.
 * @author Dr Suzy Atfield-Cutts adapted from Melanie Coles
 * @since 2020
 */

public class Salary {

    // Task 1
    public Integer salaryIncrease(int salary) { return salary + 200; }

    // Task 2
    public double salaryIncrease(double salary) { return salary + 200.5; }

    // Task 3
    public double salaryIncrease(double salary, double percent) { return salary * ((percent + 100) / 100); }

    // Task 4
    public double calculatePay(double salary) {
        double tax;
        double pension;
        double monthlyPay;

        tax = salary * 0.15;
        pension = salary * 0.13;
        monthlyPay = (salary - (tax + pension)) / 12;

        return monthlyPay;
    }

    // Task 5
    public String formatCurrency(double salary) {
        String pattern = "£###,###,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(salary);
    }
}
