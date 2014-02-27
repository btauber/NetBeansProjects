package threadedaccount;

public class Account {
    private int balance1 = 1000;
    private int balance2 = 1000;
    
    private String lock1 = new String();
    private String lock2 = new String();
    
    public int withdraw(int amount) {
        int amountToReturn = 0;
        synchronized(lock1) {
            System.out.println(Thread.currentThread().getId() +": Attempting to withdraw " + amount);
            if (balance1 >= amount) {
                //synchronized(this) {
                System.out.println(Thread.currentThread().getId() +": Balance is high enough to withdraw " + amount);
                balance1 -= amount;
                System.out.println(Thread.currentThread().getId() +": Balance is " + balance1 + " after withdrawing " + amount);
                //}
                amountToReturn += amount;
            }
            else {
                System.out.println(Thread.currentThread().getId() +": Balance is " + balance1 + " not high enough to withdraw " + amount);
            }
        }
        
        synchronized(lock2) {
            if (balance2 >= amount) {
                balance2 -= amount;
                amountToReturn += amount;
            }
            else {
            }
        }
        
        return amountToReturn;
    }
    
    public int getBalance() {
        return balance1;
    }
}
