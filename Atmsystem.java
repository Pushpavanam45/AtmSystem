import java.util.Scanner;
class bankaccount{
    public double balance ;
    public bankaccount(double initialbalance){
        this.balance = initialbalance;
    }
    public double getbalance(){
        return balance ;

    }
    public void deposite(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("deposite successful! balance:-"+balance);
        }else{
            System.out.println("Invalid deposite amount");
        }
    }
        public boolean withdraw(double amount){
            if(amount>0 && amount<=balance){
                balance-=amount;
                System.out.println("Withdrawal successfully complete! balance:"+balance);
                return true;
            }else{
                System.out.println("insufficient balance or inalid amount");
                return false;
            }


        }
    }







 class Atm {
    public bankaccount useraccount ;
    public Scanner scan ;
    public Atm(bankaccount account){
        this.useraccount = account;
        this.scan=new Scanner(System.in);
    }
    public void start(){
        while(true){
            System.out.println("ATM menu");
            System.out.println("1.withdraw");
            System.out.println("2.deposit");
            System.out.println("3.checkbalance");
            System.out.println("4.Exit");
            System.out.println("choose an option");
            int choice = scan.nextInt();

            switch(choice){
                case 1:
                performwithdrawal();
                break;
                case 2:
                performdeposit();
                break;
                case 3:
                System.out.println("current balance:"+ useraccount.getbalance());
                break;
                case 4:
                System.out.println("Thankyou for using our atm");
                return;
                default:
                System.out.println("invalid chioce. please try again");
                
            }
        }
    }
    public void performwithdrawal(){
        System.out.println("Enter amount to withdraw:");
        double amount = scan.nextDouble();
        useraccount.withdraw(amount);
    }
    public void performdeposit(){
        System.out.println("Enter amount to deposit:");
        double amount = scan.nextDouble();
        useraccount.deposite(amount);

    }
 }
    
    public class Atmsystem{
        public static void main(String [] args){
            bankaccount useraccount = new bankaccount(5000);
            Atm atm = new Atm(useraccount);
            atm.start();
        }
    }







    

