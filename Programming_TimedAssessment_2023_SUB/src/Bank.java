import exceptions.AccountNotFoundException;
import exceptions.InsufficientFundsException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    // Task 3.1: Instantiating the key variable to the "Bank" class.
    private final ArrayList<BankAccount> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }

    // Task 3.2: Reads the provided file name to find and add each bank account into a list.
    public void readAccounts(String pathName) throws FileNotFoundException {
        File fileNames = new File(pathName);
        Scanner fileScan = new Scanner(fileNames);

        while (fileScan.hasNextLine()) {
            String accountStr = fileScan.nextLine();
            String[] splitAccount = accountStr.split(",");

            if (splitAccount.length == 3) {
                accounts.add(new SavingsAccount(Integer.parseInt(splitAccount[0]), Double.parseDouble(splitAccount[1]), Double.parseDouble(splitAccount[2])));
            }
            else {
                accounts.add(new BankAccount(Integer.parseInt(splitAccount[0]), Double.parseDouble(splitAccount[1])));
            }
        }
        fileScan.close();
    }

    // Task 3.3: Returning the entire list of bank and savings accounts when requested.
    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    // Task 3.4: A method to search through the accounts list and get the account details of the bank account in question.
    public BankAccount getAccount(int accountID) throws AccountNotFoundException {
        BankAccount foundAccount = null;
        
        for (BankAccount account : this.accounts){
            if (account.getAccountID() == accountID){
                foundAccount = account;
                break;
            }
        }

        if (foundAccount == null){
            throw new AccountNotFoundException(accountID);
        }

        return foundAccount;
    }

    // Task 3.5: A method to search through the accounts list and get the accounts position in the list.
    public int getAccountIndex(int accountID) throws AccountNotFoundException {
        int accountIndex = 0;

        for (BankAccount account : this.accounts){
            if (account.getAccountID() == accountID){
                accountIndex = this.accounts.indexOf(account);
                break;
            }
        }

        if (accountID <= 0){
            throw new AccountNotFoundException(accountID);
        }

        return accountIndex;
    }

    // Task 3.6: A method to find the next available account ID.
    public int getNextAccountID(){
        return this.accounts.get(this.accounts.size() - 1).getAccountID() + 1;
    }

    // Task 3.7: A method to create a new bank account by using getNextAccountID.
    public BankAccount openBankAccount() {
        BankAccount newBankAccount = new BankAccount(getNextAccountID(), 0);

        accounts.add(newBankAccount);

        return newBankAccount;
    }

    // Task 3.8: Similar to task 3.7 of creating a new account but a savings account.
    public SavingsAccount openSavingsAccount(double interestRate) {
        SavingsAccount newSavingsAccount = new SavingsAccount(getNextAccountID(), 0, interestRate);

        accounts.add(newSavingsAccount);

        return newSavingsAccount;
    }

    // Task 3.9: When an account holder no longer wants their account open so their account is deleted from the list.
    public void closeAccount(int accountID) throws AccountNotFoundException {
        this.accounts.remove(getAccountIndex(accountID));
    }

    // Task 3.10: Taking three inputs to withdraw funds from one accounts and deposit it into another account.
    public void transferFunds(int originatingAccountID, int destinationAccountID, double transferAmount) throws IllegalArgumentException, InsufficientFundsException, AccountNotFoundException {
        BankAccount originatingAccount = getAccount(originatingAccountID);
        BankAccount destinationAccount = getAccount(destinationAccountID);
        double originatingAccountBalance = originatingAccount.getCurrentBalance();

        if (transferAmount == 0){
            throw new IllegalArgumentException("Transfer amount should be more than zero!");
        }
        else if (destinationAccount == null){
            throw new AccountNotFoundException(destinationAccountID);
        }
        else if (originatingAccountBalance < transferAmount){
            throw new InsufficientFundsException(originatingAccountBalance, transferAmount);
        }
        else{
            originatingAccount.withdraw(transferAmount);
            destinationAccount.deposit(transferAmount);
        }
    }

    // Task 3.11: Writes the list of accounts into a file.
    public void saveAccounts(String pathName) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(pathName)));
        for (BankAccount account : accounts){
            String accountStr = account.getAccountID() + "," + account.getCurrentBalance();
            out.println(accountStr);
        }
        out.close();
    }
}
