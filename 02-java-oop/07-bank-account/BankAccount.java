import java.io.*;
import java.util.Random; 
import java.util.HashMap;

public class BankAccount {
    private static int numberOfAccounts = 0; 
    private static HashMap<String, Double> totalAmount = new HashMap<String, Double>();

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void displayAccountTotalAmounts() {
        System.out.println(totalAmount);
    }

    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public BankAccount() {
        this.accountNumber = BankAccount.randomAccountNumber();
        numberOfAccounts++;
        totalAmount.put(this.accountNumber, 0.0);
    }

    public void deposit(String destination, double amount) {
        if (destination.toLowerCase().equals("checking")){
            this.checkingBalance = this.checkingBalance + amount;
        } else if (destination.toLowerCase().equals("saving")){
            this.savingsBalance = this.savingsBalance + amount;
        }
        double total = totalAmount.get(this.accountNumber);
        totalAmount.put(this.accountNumber, total + amount);
    }

    public void withdraw(String source, double amount) {
        if (source.toLowerCase().equals("checking")){
            if (this.checkingBalance - amount >= 0) {
                this.checkingBalance = this.checkingBalance - amount;
                double total = totalAmount.get(this.accountNumber);
                totalAmount.put(this.accountNumber, total - amount);
            }
        } else if (source.toLowerCase().equals("saving")){
            if (this.savingsBalance - amount >= 0) {
                this.savingsBalance = this.savingsBalance - amount;
                double total = totalAmount.get(this.accountNumber);
                totalAmount.put(this.accountNumber, total - amount);
            }
        }
    }

    public void displayCheckingBalance() {
        System.out.println(this.checkingBalance);
    }

    public void displaySavingsBalance() {
        System.out.println(this.savingsBalance);
    }

    private static String randomAccountNumber() {
        int high = Integer.MAX_VALUE;
        int low = 1000000000;
        Random r = new Random();
        int result = r.nextInt(high - low) + low;
        return String.valueOf(result);
    }

}