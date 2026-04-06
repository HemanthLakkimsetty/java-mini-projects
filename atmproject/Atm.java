public class Atm {
    //atm lo functions vachesi 1.check balance 2.withdraw 3.deposit 4.exit
    private double balance;
    private double depositAmount;
    private double withdrawAmount;

    //getters
    public double getBalance() {
        return balance;
    }
    public double getDepositAmount() {
        return depositAmount;
    }
    public double getWithdrawAmount(){
        return withdrawAmount;
    }

    //setters
    public void setBalance(double balance){
        this.balance=balance;
    }
    public void setDepositAmount(double depositAmount){
        this.depositAmount=depositAmount;
    }
    public void setWithdrawAmount(double withdrawAmount){
        this.withdrawAmount=withdrawAmount;
    }
    @Override
    public String toString() {
        return "Atm{" +
                "balance=" + balance +
                ", depositAmount=" + depositAmount +
                ", withdrawAmount=" + withdrawAmount +
                '}';
    }
    
}
