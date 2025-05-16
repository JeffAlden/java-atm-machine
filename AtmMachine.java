import java.util.Scanner;

public class AtmMachine {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int balance = 1000;

            OUTER:

            while (true) {

                System.out.println("Welcome to ATM Machine");
                System.out.println("[1] Check Balance");
                System.out.println("[2] Withdraw");
                System.out.println("[3] Deposit");
                System.out.println("[4] Exit");
                System.out.print("Enter your choice: ");
                int choice;
                try {
                    choice = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear the invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Your current balance is " + balance);
                        break;
                    case 2:
                        System.out.print("Enter your amount to withdraw: ");
                        int amountToWithdraw = scanner.nextInt();
                        if (balance < amountToWithdraw || amountToWithdraw <= 0) {
                            System.out.println("Invalid amount. Please try again.");
                        } else {
                            balance -= amountToWithdraw;
                            System.out.println("Please collect your cash. Your new balance is " + balance);
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to Deposit: ");
                        int amountDeposit = scanner.nextInt();
                        if (amountDeposit <= 0 && amountDeposit <= 100) {
                            System.out.println("Enter valid amount");
                        } else {
                            balance += amountDeposit;
                            System.out.println("Your new balance is " + balance);
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for Banking with us! ");
                        break OUTER;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
