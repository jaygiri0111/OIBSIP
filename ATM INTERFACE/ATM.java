
/* ....................................
 welcome to jay prakash giri code
......................................*/
import java.util.*;

class Enterpassword {
    static void password() {
        int password;
        Scanner sc = new Scanner(System.in);
        System.out.println("***************************");
        System.out.println("welcome to Indian ATM Machine");
        System.out.println("............................");

        System.out.println("Enter your password(4 digits)");
        System.out.print("password: ");
        password = sc.nextInt();
        System.out.println("Password Entered Successfully");
        System.out.println("............................");
        System.out.println("Welcome to Transactional Authentication");

    }

}

class transactionManager {
    public static void balance() {
        System.out.println("Avilable balance = " + ATM.balance);
        System.out.println(".................................");

    }

    static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*************************");
        System.out.print("Enter amount to be withdraw: ");
        int w_amount = sc.nextInt();
        if (w_amount <= ATM.balance) {
            ATM.balance = ATM.balance - w_amount;
            ATM.history.add(Integer.toString(w_amount));
            ATM.history.add("Withdrawed.");
            System.out.println("Withdrawed amount = " + w_amount + "/-");
            System.out.println("withdraw successfully");
            System.out.println(".............................");

        } else {
            System.out.println("...........................");
            System.out.println("insufficient balance");
            System.out.println(".............................");
        }
    }

    public static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***************************");
        System.out.print("Enter amount to be deposit: ");
        int d_amount = sc.nextInt();
        ATM.balance = ATM.balance + d_amount;
        ATM.history.add(Integer.toString(d_amount));
        ATM.history.add("deposited");
        System.out.println("Amount Deposited = " + d_amount + "/-");
        System.out.println("depoisted successfully");
        System.out.println("............................");

    }

    static void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***************************");
        System.out.println("Enter details of Reciever");
        System.out.println("...........................");
        System.out.println("Reciever Account holder name : ");
        // sc.nextLine();
        String rec_name = sc.nextLine();
        System.out.println("Enter Reciever Account Number: ");
        String rec_accnumber = sc.nextLine();
        System.out.print("Enter Amount to be transfer: ");
        int r_amount = sc.nextInt();
        if (r_amount <= ATM.balance) {
            ATM.balance = ATM.balance - r_amount;
            ATM.history.add(Integer.toString(r_amount));
            ATM.history.add("Transfered");
            System.out.println("Transfered amount = " + r_amount + "/-");
            System.out.println(".............................");

        } else {
            System.out.println("...........................");
            System.out.println("Insufficient Balance");
            System.out.println("............................");

        }

    }

    static void transactionhistory() {
        System.out.println("*****************************");
        System.out.println("Transaction History :");
        System.out.println("............................");

        int m = 0;
        if (ATM.balance > 0) {
            for (int i = 0; i < (ATM.history.size() / 2); i++) {
                System.out.print("Rs.");
                for (int j = 0; j < 2; j++) {
                    System.out.print(ATM.history.get(m) + " ");
                    m++;
                }
                System.out.println("\n..........................");
            }
        } else {
            System.out.println("Your account is empty.No Transaction has been done.");
        }

    }
}

public class ATM {
    public static int balance = 0;
    public static ArrayList<String> history = new ArrayList<String>();

    static void option() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***************************");
        System.out.println("Select option : ");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. check balance");
        System.out.println("6. Exit");
        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                transactionManager.transactionhistory();
                ATM.option();
                break;
            case 2:
                transactionManager.withdraw();
                ATM.option();

                break;
            case 3:
                transactionManager.deposit();
                ATM.option();

                break;
            case 4:
                transactionManager.transfer();
                ATM.option();

                break;
            case 5:
                transactionManager.balance();
                ATM.option();

                break;
            case 6:
                System.out.println("Thank you for your transaction");
                System.out.println(".............................");

                System.exit(0);
        }

    }

    public static void main(String[] args) {
        Enterpassword.password();
        ATM.option();

    }

}
