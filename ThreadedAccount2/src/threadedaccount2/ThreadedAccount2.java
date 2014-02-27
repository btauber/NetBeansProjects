package threadedaccount2;

import java.util.Random;

public class ThreadedAccount2 {

    public static void main(String[] args) {
        final Random random = new Random();
        final Account account = new Account();
        
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    account.deposit(random.nextInt(100));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        return;
                    }
                }
            }
        }).start();
        
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    account.withdraw(random.nextInt(100));
                    /*try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        return;
                    }*/
                }
            }
        }).start();
    }
}
