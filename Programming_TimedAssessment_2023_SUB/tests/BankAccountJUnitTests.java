import exceptions.InsufficientFundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(AssessmentTestWatcher.class)
public class BankAccountJUnitTests {

    BankAccount testAccount1 = new BankAccount(1, 10492.24);
    BankAccount testAccount2 = new BankAccount(20006, 0.00);
    BankAccount testAccount3 = new BankAccount(32378191, 345.00);

    @Test
    void testBankAccountGetters(){
        assertEquals(1, testAccount1.getAccountID());
        assertEquals(10492.24, testAccount1.getCurrentBalance());
        assertEquals(20006, testAccount2.getAccountID());
        assertEquals(0.00, testAccount2.getCurrentBalance());
        assertEquals(32378191, testAccount3.getAccountID());
        assertEquals(345.00, testAccount3.getCurrentBalance());
    }

    @Test
    void testBankAccountFormattedAccountNumbers(){
        assertEquals("00000001", testAccount1.getFormattedAccountNumber());
        assertEquals("00020006", testAccount2.getFormattedAccountNumber());
        assertEquals("32378191", testAccount3.getFormattedAccountNumber());
    }

    @Test
    void testBankAccountDeposits(){
        testAccount1.deposit(2);
        assertEquals(10494.24, testAccount1.getCurrentBalance());
        testAccount1.deposit(128.58);
        assertEquals(10622.82, testAccount1.getCurrentBalance());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testAccount1.deposit(-2.00));
        assertEquals("Deposit amount must be greater than 0.00!", exception.getMessage());

        testAccount2.deposit(5);
        assertEquals(5.00, testAccount2.getCurrentBalance());
        testAccount2.deposit(55.55);
        assertEquals(60.55, testAccount2.getCurrentBalance());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> testAccount2.deposit(-200.00));
        assertEquals("Deposit amount must be greater than 0.00!", exception2.getMessage());

        testAccount3.deposit(867542.20);
        assertEquals(867887.20, testAccount3.getCurrentBalance());
        testAccount3.deposit(55.55);
        assertEquals(867942.75, testAccount3.getCurrentBalance());
        testAccount3.deposit(0.01);
        assertEquals(867942.76, testAccount3.getCurrentBalance());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> testAccount3.deposit(0.00));
        assertEquals( "Deposit amount must be greater than 0.00!", exception3.getMessage());
    }

    @Test
    void testBankAccountWithdrawals(){
        testAccount1.withdraw(2);
        assertEquals(10490.24, testAccount1.getCurrentBalance());
        testAccount1.withdraw(128.58);
        assertEquals(10361.66, testAccount1.getCurrentBalance());
        
        InsufficientFundsException exception1 = assertThrows(InsufficientFundsException.class, () -> testAccount2.withdraw(2.00));
        assertEquals("Insufficient funds for this withdrawal. (Available Balance:0.0, Amount Requested:2.0)", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> testAccount2.withdraw(0.00));
        assertEquals("Withdrawal amount must be greater than 0.00!", exception2.getMessage());

        testAccount3.withdraw(1);
        assertEquals(344.00, testAccount3.getCurrentBalance());
        testAccount3.withdraw(128.58);
        assertEquals(215.42, testAccount3.getCurrentBalance());
    }

    @Test
    void testBankAccountToString(){
        assertEquals("A/C No: 00000001, Balance: £10,492.24", testAccount1.toString());
        assertEquals("A/C No: 00020006, Balance: £0.00", testAccount2.toString());
        assertEquals("A/C No: 32378191, Balance: £345.00", testAccount3.toString());
    }
}
