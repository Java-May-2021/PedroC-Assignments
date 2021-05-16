public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount();
        ba1.deposit("checking", 100.0);
        ba1.deposit("saving", 1000.0);
        ba1.withdraw("checking", 100.0);
        ba1.withdraw("saving", 1000.0);
        ba1.displayCheckingBalance();
        ba1.displaySavingsBalance();

        BankAccount ba2 = new BankAccount();
        ba2.deposit("checking", 500.0);
        ba2.deposit("saving", 0.0);
        ba2.withdraw("checking", 100.0);
        ba2.withdraw("saving", 100.0);
        ba2.displayCheckingBalance();
        ba2.displaySavingsBalance();

        BankAccount ba3 = new BankAccount();
        ba3.deposit("checking", 200.0);
        ba3.deposit("saving", 200.0);
        ba3.withdraw("checking", 10.0);
        ba3.withdraw("saving", 10.0);
        ba3.displayCheckingBalance();
        ba3.displaySavingsBalance();

        System.out.println(BankAccount.getNumberOfAccounts());
        BankAccount.displayAccountTotalAmounts();
    }
}