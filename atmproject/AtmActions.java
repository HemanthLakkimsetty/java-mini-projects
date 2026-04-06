import java.util.Map;
import java.util.HashMap;
public class AtmActions implements AtmInterface {
    Atm atm=new Atm();
    Map<String,Double> ministatement=new HashMap<>();

    public void checkBalance() {
        System.out.println("Current balance : "+atm.getBalance());
    }
    public void withdraw(double withdrawAmount) {
        if(withdrawAmount%100==0){
            if(atm.getBalance()>=withdrawAmount){
                System.out.println("Amount withdrawn :"+withdrawAmount);
                atm.setWithdrawAmount(atm.getBalance()-withdrawAmount);
                ministatement.put(withdrawAmount+"withdrawn",withdrawAmount);
                //calling checkBalance method to show the balance after withdraw
                checkBalance();
            }
            else{
                System.out.println("Insufficient balance");
            }
        }else{
            System.out.println("please enter the amount in multiple of 100 or 500");
        }
        
    }
    public void deposit(double depositAmount) {
        System.out.println("Deposit amount :"+depositAmount);
        atm.setBalance(atm.getBalance()+depositAmount);
        ministatement.put(depositAmount+"deposited",depositAmount);

    }
    public void viewMinistatement() {
        ministatement.forEach((key,value)->{
            System.out.println(key+" : "+value);
        });
    }

    
}
