package threadedaccount2;

public class Account {
    private int balance;
    
    public synchronized int withdraw(int amount) {
        System.out.println(Thread.currentThread().getId() + ": Attempting to withdraw " + amount + ". Balance is " + balance);
        while (balance < amount) {
            try {
                System.out.println(Thread.currentThread().getId() + ": Unable to withdraw " + amount + ". Balance is " + balance + ". Waiting...");
                wait();
            } catch(InterruptedException e) {
                return 0;
            }
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getId() + ": Successfully withdrew " + amount + ". Balance is now " + balance);
        return amount;
  
        //System.out.println(Thread.currentThread().getId() + ": Unable to withdraw " + amount + ". Balance is :" + balance);
        //return 0;
    }
    
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getId() + ": Deposited " + amount + ". Balance is :" + balance);
        notifyAll();
    }
}
