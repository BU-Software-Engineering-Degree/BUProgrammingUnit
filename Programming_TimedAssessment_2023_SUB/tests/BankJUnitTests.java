import exceptions.AccountNotFoundException;
import exceptions.InsufficientFundsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(AssessmentTestWatcher.class)
public class BankJUnitTests {

    Bank bank;

    ArrayList<BankAccount> coreBankAccounts = new ArrayList<>();

    @BeforeEach
    void setup() throws Exception {
        bank = new Bank();
        bank.readAccounts("accounts.txt");

        coreBankAccounts.add(new BankAccount(1, 35.00));
        coreBankAccounts.add(new BankAccount(2, 134.55));
        coreBankAccounts.add(new BankAccount(3, 14403928.05));
        coreBankAccounts.add(new BankAccount(4, 45655.00));
        coreBankAccounts.add(new SavingsAccount(5, 250.00, 0.075));
    }

    @Test
    void testBankGetAccounts() {
        assertEquals(coreBankAccounts, bank.getAccounts());
    }

    @Test
    void testOpenBankAccount() {
        assertEquals(new BankAccount(6, 0.00), bank.openBankAccount());
        assertEquals(new BankAccount(7, 0.00), bank.openBankAccount());
    }

    @Test
    void testOpenSavingsAccount() {
        assertEquals(new SavingsAccount(6, 0.00, 0.045), bank.openSavingsAccount(0.045));
        assertEquals(new SavingsAccount(7, 0.00, 0.085), bank.openSavingsAccount(0.085));
    }

    @Test
    void testCloseAccount() throws Exception {
        coreBankAccounts.add(new SavingsAccount(6, 0.00, 0.012));

        bank.openSavingsAccount(0.012);
        BankAccount tempAccount = bank.openBankAccount();
        bank.closeAccount(tempAccount.getAccountID());

        bank.saveAccounts("accounts.txt");

        assertEquals(coreBankAccounts, bank.getAccounts());
    }

    @Test
    void testGetAccount(){
        assertEquals(new BankAccount(1, 35.00), bank.getAccount(1));
        assertEquals(new BankAccount(2, 134.55), bank.getAccount(2));

        bank.openBankAccount();
        assertEquals(new BankAccount(6, 0.00), bank.getAccount(6));

        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> bank.getAccount(23299));
        assertEquals("Account not found with accountID: 23299", exception.getMessage());
    }

    @Test
    void testGetAccountIndex(){
        assertEquals(0, bank.getAccountIndex(1));
        assertEquals(1, bank.getAccountIndex(2));

        bank.openBankAccount();
        assertEquals(5, bank.getAccountIndex(6));
    }

    @Test
    void testGetNextAccountID(){
        assertEquals(6, bank.getNextAccountID());
        bank.openBankAccount();
        assertEquals(7, bank.getNextAccountID());
        bank.closeAccount(6);
        assertEquals(6, bank.getNextAccountID());
    }

    @Test
    void testTransferFunds() {
        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> bank.transferFunds(1, 23239, 0.01));
        assertEquals("Account not found with accountID: 23239", exception.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> bank.transferFunds(1, 2, 0.00));
        assertEquals("Transfer amount should be more than zero!", exception2.getMessage());

        InsufficientFundsException exception3 = assertThrows(InsufficientFundsException.class, () -> bank.transferFunds(1, 2, 45.00));
        assertEquals("Insufficient funds for this withdrawal. (Available Balance:35.0, Amount Requested:45.0)", exception3.getMessage());

        bank.transferFunds(1, 2, 5.00);
        assertEquals(30.00, bank.getAccount(1).getCurrentBalance());
        assertEquals(139.55, bank.getAccount(2).getCurrentBalance());

        bank.transferFunds(2, 3, 42.55);
        assertEquals(97.00000000000001, bank.getAccount(2).getCurrentBalance());
        assertEquals(1.4403970600000001E7, bank.getAccount(3).getCurrentBalance());
    }

    @Test
    void testSaveAccounts() throws IOException {
        coreBankAccounts.add(new BankAccount(6, 0.00));
        coreBankAccounts.add(new BankAccount(7, 0.00));
        coreBankAccounts.add(new SavingsAccount(8, 0.00, 0.045));
        coreBankAccounts.add(new SavingsAccount(9, 0.00, 0.085));

        bank.openBankAccount();
        bank.openBankAccount();
        bank.openSavingsAccount(0.045);
        bank.openSavingsAccount(0.085);

        bank.saveAccounts("savedAccounts.txt");

        bank.getAccounts().clear();

        bank.readAccounts("savedAccounts.txt");
        assertEquals(coreBankAccounts, bank.getAccounts());
    }

    @AfterEach
    void resetAccountsFile() throws IOException {
        PrintWriter pW = new PrintWriter(new BufferedWriter(new FileWriter("accounts.txt")));
        pW.println("1,35.00");
        pW.println("2,134.55");
        pW.println("3,14403928.05");
        pW.println("4,45655.00");
        pW.println("5,250.00,0.075");
        pW.close();
    }
}
