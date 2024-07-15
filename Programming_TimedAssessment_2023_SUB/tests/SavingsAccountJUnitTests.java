import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(AssessmentTestWatcher.class)
public class SavingsAccountJUnitTests {

    SavingsAccount testSavingsAccount1 = new SavingsAccount(52312233, 10492.24, 0.05);
    SavingsAccount testSavingsAccount2 = new SavingsAccount(9866422, 2312.00, 0.075);

    @Test
    void testSavingsAccountGetters(){
        assertEquals(52312233, testSavingsAccount1.getAccountID());
        assertEquals(10492.24, testSavingsAccount1.getCurrentBalance());
        assertEquals(0.05, testSavingsAccount1.getInterestRate());
        assertEquals(9866422, testSavingsAccount2.getAccountID());
        assertEquals(2312.00, testSavingsAccount2.getCurrentBalance());
        assertEquals(0.075, testSavingsAccount2.getInterestRate());
    }

    @Test
    void testSavingsAccountInterestSetter(){
        testSavingsAccount1.setInterestRate(0.1);
        assertEquals(0.1, testSavingsAccount1.getInterestRate());

        testSavingsAccount2.setInterestRate(0.04);
        assertEquals(0.04, testSavingsAccount2.getInterestRate());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> testSavingsAccount1.setInterestRate(-0.01));
        assertEquals("Interest Rate cannot be less than 0%!", exception.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> testSavingsAccount2.setInterestRate(1.5));
        assertEquals("Interest Rate cannot be greater than 100%!", exception2.getMessage());
    }

    @Test
    void testSavingsAccountAnnualReturn(){
        assertEquals("£524.61", testSavingsAccount1.getEstimatedAnnualReturn());
        assertEquals("£173.40", testSavingsAccount2.getEstimatedAnnualReturn());
    }

    @Test
    void testSavingsAccountMonthlyReturn(){
        assertEquals("£43.72", testSavingsAccount1.getEstimatedMonthlyReturn());
        assertEquals("£14.45", testSavingsAccount2.getEstimatedMonthlyReturn());
    }

    @Test
    void testSavingsAccountToString(){
        assertEquals("A/C No: 52312233, Balance: £10,492.24, Interest Rate: 5.0%", testSavingsAccount1.toString());
        assertEquals("A/C No: 09866422, Balance: £2,312.00, Interest Rate: 7.5%", testSavingsAccount2.toString());
    }
}
