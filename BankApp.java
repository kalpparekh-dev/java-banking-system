import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {

    static BankAccount findAccount(ArrayList<BankAccount> accounts, int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accNo) {
                return acc;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int nextAccountNumber = 1001;

        while (true) {

            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            // CREATE ACCOUNT
            if (choice == 1) {

                System.out.print("Enter name: ");
                String name = sc.nextLine();

                double balance;
                try {
                    System.out.print("Enter initial balance: ");
                    balance = Double.parseDouble(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid balance!");
                    continue;
                }

                BankAccount newAcc = new BankAccount(nextAccountNumber, name, balance);
                accounts.add(newAcc);

                System.out.println("Account created! Account Number: " + nextAccountNumber);
                nextAccountNumber++;
            }

            // DEPOSIT
            else if (choice == 2) {

                int accNo;
                try {
                    System.out.print("Enter account number: ");
                    accNo = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid account number!");
                    continue;
                }

                BankAccount acc = findAccount(accounts, accNo);

                if (acc != null) {

                    double amt;
                    try {
                        System.out.print("Enter amount: ");
                        amt = Double.parseDouble(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid amount!");
                        continue;
                    }

                    if (amt <= 0) {
                        System.out.println("Amount must be positive!");
                        continue;
                    }

                    acc.deposit(amt);

                } else {
                    System.out.println("Account not found!");
                }
            }

            // WITHDRAW
            else if (choice == 3) {

                int accNo;
                try {
                    System.out.print("Enter account number: ");
                    accNo = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid account number!");
                    continue;
                }

                BankAccount acc = findAccount(accounts, accNo);

                if (acc != null) {

                    double amt;
                    try {
                        System.out.print("Enter amount: ");
                        amt = Double.parseDouble(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid amount!");
                        continue;
                    }

                    if (amt <= 0) {
                        System.out.println("Amount must be positive!");
                        continue;
                    }

                    acc.withdraw(amt);

                } else {
                    System.out.println("Account not found!");
                }
            }

            // CHECK BALANCE
            else if (choice == 4) {

                int accNo;
                try {
                    System.out.print("Enter account number: ");
                    accNo = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid account number!");
                    continue;
                }

                BankAccount acc = findAccount(accounts, accNo);

                if (acc != null) {
                    acc.checkBalance();
                } else {
                    System.out.println("Account not found!");
                }
            }

            // EXIT
            else if (choice == 5) {
                System.out.println("Thank you!");
                break;
            }

            // INVALID OPTION
            else {
                System.out.println("Invalid option!");
            }
        }

        sc.close();
    }
}