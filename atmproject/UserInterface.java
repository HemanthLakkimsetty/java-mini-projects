import java.util.Scanner;
public class UserInterface {
    public  static boolean login(String username,int pin){
        if(username.equals("Java")&& pin==2426){
            System.out.println("Login successful");
            return true;
        }
        else{
            System.out.println("Invalid username or pin");
            return false;
        }
    }
    public static void userChoice( int choice){
        Scanner sc=new Scanner(System.in);
        AtmActions atmActions=new AtmActions();
        switch(choice){
                    case 1:
                        atmActions.checkBalance();
                        break;
                    case 2:
                        System.out.println("Enter the amount to withdraw : ");
                        double withdrawAmount=sc.nextDouble();
                        atmActions.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Enter the amount to deposit : ");
                        double depositAmount=sc.nextDouble();
                        atmActions.deposit(depositAmount);
                        break;
                    case 4:
                        atmActions.viewMinistatement();
                        break;
                    case 5:
                        System.out.println("Thank you for using JAVA ATM");
                        //here we exit from infinite loop and end the program
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice, please try again");
                }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the JAVA ATM");
        System.out.println("Enter username : ");
        String userName=sc.nextLine();
        System.out.println("Enter pin : ");
        int atmPin=sc.nextInt();
        if(login(userName,atmPin)){
            while(true){
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. View Ministatement");
                System.out.println("5. Exit");
                System.out.println("Enter your choice : ");
                int choice=sc.nextInt();
                userChoice(choice);
        }
        }
        
    }
    
}
