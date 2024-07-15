import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * SalaryCalculatorJUnitTests - part of Control Flow
 * JUnit testing the SalaryCalculator class
 * Selection and Iteration examples
 * @author Dr Suzy Atfieldcutts adapted from Melanie Coles
 * @since 2020
 */

class SalaryCalculatorUnitTest {

    SalaryCalculator salary;

    @BeforeEach
    void createObject() {
        salary = new SalaryCalculator();
    }

    // Task 1
    @Test
    void testHighestOfTwo() {
        assertEquals(30000.0, salary.salaryTax(60000.00));
        assertEquals(21000.0, salary.salaryTax(30000.00));
        assertEquals(17000.0, salary.salaryTax(20000.00));
    }

    // Task 2
    @Test
    void testCalculateNI() {
        assertEquals(44000.0, salary.calculateNI(50000.00, 'A'));
        assertEquals(47075.0, salary.calculateNI(50000.00, 'B'));
        assertEquals(49000.0, salary.calculateNI(50000.00, 'C'));
        assertEquals(50000.0, salary.calculateNI(50000.00, 'D'));
    }

    // Task 3
    @Test
    void testSalaryTotal() {
        double[] salaries = {23000.50, 25478.66, 78496.56};
        assertEquals(126975.72, salary.salaryTotal(salaries));
        double[] salaries1 = {1.50, 1.50, 0.00};
        assertEquals(3.0, salary.salaryTotal(salaries1));
        double[] salaries2 = {1.50, 1.50, 0.00, 100000.00, 123456.00};
        assertEquals(223459.0, salary.salaryTotal(salaries2));
    }

    // Task 4
    @Test
    void testSalaryAverage() {
        double[] salaries = {23000.50, 25478.66, 78496.56};
        assertEquals(42325.24, salary.salaryAverage(salaries));
        double[] salaries1 = {1.50, 1.50, 0.00};
        assertEquals(1.0, salary.salaryAverage(salaries1));
        double[] salaries2 = {1.50, 1.50, 0.00, 100000.00, 123456.00};
        assertEquals(44691.8, salary.salaryAverage(salaries2));
    }

    // Task 5
    @Test
    void testSalaryIncrease() {
        double[] salaries = {23000.50, 25478.66, 78496.50};
        double[] newSalaries = {24150.525, 26752.593, 82421.325};
        assertArrayEquals(newSalaries, salary.salaryIncrease(salaries));
        double[] salaries1 = {1.00, 2.50, 0.00};
        double[] newSalaries1 = {1.05, 2.625, 0.0};
        assertArrayEquals(newSalaries1, salary.salaryIncrease(salaries1));
        double[] salaries2 = {1.50, 1.50, 0.00, 100000.00, 123456.00};
        double[] newSalaries2 = {1.575, 1.575, 0.0, 105000.00, 129628.80};
        assertArrayEquals(newSalaries2, salary.salaryIncrease(salaries2));
    }
}
