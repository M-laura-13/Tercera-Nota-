
public class App {
 
    public static class BankAccount {
        //Atributos 
    String accountNumber;
    String owner;
    double balance;
    //Metodos 
    void deposit(double amount){
        balance +=amount;
        System.out.println("Deposito:"+ amount + "nuevo balance:"+ balance);

    }
}
    public static void main(String[] args) throws Exception {
        BankAccount account1 = new BankAccount();
        account1.accountNumber = "109-2733-134";
        account1.balance= 2000000;
        account1.owner = "Laura";
        
       account1.deposit(5000000);

        System.err.println(account1.owner);
        
        System.err.println(account1.accountNumber);
    }
}
