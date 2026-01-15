import java.util.Scanner;

class Withdraw{
    static int withdraw(int bal,Scanner sc){
        System.out.print("Enter the withdraw amount :");
        int withdrawamt = sc.nextInt();
        if(withdrawamt <= bal){
            bal = bal - withdrawamt;
            System.out.println("Amount withdrawed successfully!!");
            TransactionHistory.addTransaction("Withdraw :" + withdrawamt + " | Balance :" + bal);
        }else{
            System.out.println("Insufficient balance!");
        }
        return bal;
    }
}
class Deposit{
    static int deposit(int bal,Scanner sc){
        System.out.print("Enter the deposit amount :");
        int deposit = sc.nextInt();
        int balance = bal + deposit;
        TransactionHistory.addTransaction("Deposit :" + deposit + " | Balance :" + balance);
        return balance;
    }
}
class Transfer{
    static int transfer(int bal, Scanner sc){
        System.out.print("Enter the receiver id :");
        int id = sc.nextInt();
        System.out.print("Enter the transfer amount :");
        int amt = sc.nextInt();
        if(amt <= bal){
            bal = bal - amt;
            System.out.println("Transaction completed successfully!");
            TransactionHistory.addTransaction("Transfer amount :" + amt + " | Balance :" + bal);
        }else{
            System.out.println("Insufficient balance!");
        }
        return bal;
    }
}
class Quit{
    static void quit(int balance){
        System.out.println("Final Balance :" + balance);
        System.out.println("Thank you for using ATM");
    }
}
class TransactionHistory{
    static String history = "";
    static void addTransaction(String record){
        history = history + record + "\n";
    }
    static void transaction(){
        if(history.equals("")){
            System.out.println("No transactions yet!!");
        }else{
            System.out.println("Transactions are :");
            System.out.println(history);
        }
    }
}
public class AtmInterface {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the user ID :");
        int user_Id = sc.nextInt();
        System.out.print("Enter the user Pin :");
        int user_Pin = sc.nextInt();
        System.out.print("Enter the balance :");
        int balance = sc.nextInt();
        int choice;
        do{
            System.out.println("---ATM MENU---");
            System.out.println("1.Withdraw");
            System.out.println("2.Deposit");
            System.out.println("3.Transfer");
            System.out.println("4.Transaction History");
            System.out.println("5.Quit");
            System.out.print("Enter the choice :");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    balance = Withdraw.withdraw(balance,sc);
                    System.out.print("Total after withdraw :" + balance);
                    System.out.println();
                    break;
                case 2: 
                    balance = Deposit.deposit(balance,sc);
                    System.out.print("Total after deposit :" + balance);
                    System.out.println();
                    break;
                case 3:
                    balance = Transfer.transfer(balance,sc);
                    System.out.print("Total after transfer :" + balance);
                    System.out.println();
                    break;
                case 4: TransactionHistory.transaction();
                    break;                   
                case 5:
                    Quit.quit(balance);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while(choice!=5);
        sc.close();
        System.out.println("All the transactions completed!!");
    }
}