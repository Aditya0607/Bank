import java.util.Scanner;

class BankAcc {
    private int accNum;
    private String cusName;
    private double balance;
    private static int noOfAcc = 0;

    public String getAccInfo() {
        return "Account Number : " + accNum + "\nCustomer Name : " + cusName + "\nBalance : " + balance + "\n";
    }

    public BankAcc(String cusName1, double balance1) {
        cusName = cusName1;
        balance = balance1;
        noOfAcc++;
        accNum = noOfAcc;
    }

    public int getAccountNum() {
        return accNum;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount to be deposited should be more than 0!");
        } else {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount to be withdrawn should be more than 0!");
        } else {
            if (balance < amount) {
                System.out.println("Insufficient Balance!!");
            } else {
                balance -= amount;
            }
        }
    }
}

class BankF {
    private final BankAcc[] accounts;
    private int n = 3;
    private int numOfAcc = 0;

    public BankF() {
        accounts = new BankAcc[n];
        numOfAcc = 0;
    }

    public int openNewAcc(String customerName, double openingBalance) {
        BankAcc b = new BankAcc(customerName, openingBalance);
        accounts[numOfAcc] = b;
        numOfAcc++;
        n++;
        return b.getAccountNum();
    }

    public void depositTo(int accountNum, double amount) {
        for (int i = 0; i < numOfAcc; i++) {
            if (accountNum == accounts[i].getAccountNum()) {
                accounts[i].deposit(amount);
                System.out.println("Amount deposited successfully!");
                return;
            }
        }
        System.out.println("Account Number not Found!");
    }

    public void withdrawFrom(int accountNum, double amount) {
        for (int i = 0; i < numOfAcc; i++) {
            if (accountNum == accounts[i].getAccountNum()) {
                accounts[i].withdraw(amount);
                System.out.println("Amount withdrawn successfully!");
                return;
            }
        }
        System.out.println("Account Number not Found!");
    }

    public void printAccInfo(int accountNum) {
        for (int i = 0; i < numOfAcc; i++) {
            if (accountNum == accounts[i].getAccountNum()) {
                System.out.println(accounts[i].getAccInfo());
                return;
            }
        }
        System.out.println("Account Number not Found!");
    }
}

public class bank {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankF myBank = new BankF();

        int c;

        do {
            System.out.println("\n");
            System.out.println("\t---- Bank ----");
            System.out.println("1. Open a new Bank Account");
            System.out.println("2. Deposit into Bank Account");
            System.out.println("3. Withdraw from Bank Account");
            System.out.println("4. Account Balance");
            System.out.println("5. Exit");

            System.out.println("\nEnter Choice : ");
            c = scan.nextInt();

            switch (c) {
                case 1:
                    System.out.println("Enter Customer Name : ");
                    String name = scan.next();
                    System.out.println("Enter Opening Balance :");
                    double b = scan.nextDouble();
                    System.out.println("Account has been created.");
                    System.out.println("Account Number : " + myBank.openNewAcc(name, b));
                    break;
                case 2:
                    System.out.println("Enter Account Number : ");
                    int accNumber = scan.nextInt();
                    System.out.println("Enter Deposit Amount : ");
                    double depAmount = scan.nextDouble();
                    myBank.depositTo(accNumber, depAmount);
                    break;
                case 3:
                    System.out.println("Enter Account Number : ");
                    int an = scan.nextInt();
                    System.out.println("Enter Withdraw Amount : ");
                    double withdrawAmount = scan.nextDouble();
                    myBank.withdrawFrom(an, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Enter Account Number : ");
                    int aNum = scan.nextInt();
                    myBank.printAccInfo(aNum);
                    break;
                case 5:
                    System.exit(0);
            }
        } while (c != 5);
    }

}
