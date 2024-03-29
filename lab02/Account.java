/**
 * This class represents a bank account whose current balance is a non-negative
 * amount in US dollars.
 */
public class Account {

    private int balance;
    private Account parentAccount;

    /** Initialize an account with the given balance. */
    public Account(int balance) {

        this.balance = balance;
        this.parentAccount = null;
    }

    /** Initialize an account with the given balance and parent account. */
    public Account(int balance, Account parentAccount) {

        this.balance = balance;
        this.parentAccount = parentAccount;
    }

    /** Returns the balance for the current account. */
    public int getBalance() {
        return balance;
    }

    /** Deposits amount into the current account. */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract amount from the account if possible. If subtracting amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {
        // TODO
        if (amount < 0) {
            System.out.println("Cannot withdraw negative amount.");
        } else if (balance < amount) {
              if (parentAccount != null) {
                  if (parentAccount.withdraw(amount - balance)) {
                      withdraw(balance);
                      return true;
                  }
              } else {
                    System.out.println("Insufficient funds");
              }
        } else {
            balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * Merge account other into this account by removing all money from other
     * and depositing it into this account.
     */
    public void merge(Account other) {
        // TODO
        this.deposit(other.getBalance());
        other.withdraw(other.getBalance());
    }
}
