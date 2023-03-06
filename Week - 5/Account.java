import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner pes2ug20cs815 = new Scanner(System.in);
        double accountBalance = pes2ug20cs815.nextDouble();
        double checkingBalance = pes2ug20cs815.nextDouble();
        double savingsBalance = pes2ug20cs815.nextDouble();

        Account account = new Account(accountBalance);
        CheckingAccount checking = new CheckingAccount(checkingBalance);
        SavingsAccount savings = new SavingsAccount(savingsBalance);

        int n = pes2ug20cs815.nextInt();
        for (int i = 0; i < n; i++) {
            String accountType = pes2ug20cs815.next();
            String operation = pes2ug20cs815.next();
            double amount = pes2ug20cs815.nextDouble();

            switch (accountType) {
                case "account":
                    if (operation.equals("deposit")) {
                        account.deposit(amount);
                    }
             c       System.out.println(account.getBalance());
                    break;
                case "checking":
                    if (operation.equals("deposit")) {
                        checking.deposit(amount);
                    } else {
                        checking.withdraw(amount);
                    }
                    System.out.println(checking.getBalance());
                    break;
                case "savings":
                    if (operation.equals("deposit")) {
                        savings.deposit(amount);
                    } else {
                        savings.withdraw(amount);
                    }
                    System.out.println(savings.getBalance());
                    break;
            }
        }
        System.out.println("fin");
    }
}

class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

class CheckingAccount extends Account {
    public CheckingAccount(double balance) {
        super(balance);
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

class SavingsAccount extends CheckingAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < 0) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
        }
    }
}

