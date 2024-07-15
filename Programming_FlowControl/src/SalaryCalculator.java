/**
 * SalaryCalculator class - part of Control Flow
 * Selection and Iteration examples
 * @author Dr Suzy Atfieldcutts adapted from Melanie Coles
 * @since 2020
 */

public class SalaryCalculator {

    // Task 1
    public double salaryTax(double grossSalary) {
        double netSalary = 0;

        if(grossSalary >= 45000){
            netSalary = grossSalary * 0.5;
        }
        if(grossSalary >= 30000 && grossSalary < 45000){
            netSalary = grossSalary * 0.7;
        }
        else if(grossSalary < 30000) {
            netSalary = grossSalary * 0.85;
        }
        return netSalary;
    }

    // Task 2
    public double calculateNI(double grossSalary, char niNumberChar) {
        double netSalary = 0;

        String niNumber = ("" + niNumberChar).toUpperCase();

        if(niNumber.equals("A")){
            netSalary = grossSalary * 0.88;
        }
        if(niNumber.equals("B")){
            netSalary = grossSalary * 0.9415;
        }
        if(niNumber.equals("C")){
            netSalary = grossSalary * 0.98;
        }
        if(!(niNumber.equals("A") || niNumber.equals("B") || niNumber.equals("C"))){
            netSalary = grossSalary;
        }
        return netSalary;
    }

    // Task 3
    public double salaryTotal(double[] salaries) {
        double totalSalary = 0;

        for (double salary : salaries) {
            totalSalary = totalSalary + salary;
        }
        return totalSalary;
    }

    // Task 4
    public double salaryAverage(double[] salaries) {
        double totalSalary = 0;

        for (double salary : salaries) {
            totalSalary = totalSalary + salary;
        }
        totalSalary = totalSalary / salaries.length;
        return totalSalary;
    }

    // Task 5
    public double[] salaryIncrease(double[] oldSalaries) {
        double[] newSalaries = new double[oldSalaries.length];

        for (int i = 0; i < oldSalaries.length; i++){
            double increasedSalary = oldSalaries[i] * 1.05;
            newSalaries[i] = Math.round(increasedSalary * 1000000.0) / 1000000.0;
        }
        return newSalaries;
    }

}
