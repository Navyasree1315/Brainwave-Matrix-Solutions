package brainwaveinternship;


import java.util.Scanner;
import java.io.*;

class PersonAccount {
    private int balance;
    private String transactionHistory = "";

    public PersonAccount(int initialBalance) {
        this.balance = initialBalance;
    }
    
    public int getBalance() {
        return balance;
    }
    

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory += "Deposited: " + amount + "\n";
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory += "Withdrew: " + amount + "\n";
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void showHistory() {
        System.out.println("Transaction History:\n" + (transactionHistory.isEmpty() ? "No transactions yet." : transactionHistory));
    }
}

public class AtmMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonAccount myAccount = new PersonAccount(100000);

        while (true) {
            System.out.println("=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                	System.out.println("Current Balance: " + myAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    myAccount.deposit(sc.nextInt());
                    break;
                case 3:
                	System.out.print("Enter amount to withdraw: ");
                	myAccount.withdraw(sc.nextInt());
                    break;
                case 4:
                    myAccount.showHistory();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the ATM!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
            System.out.println();
        }
    }
}
