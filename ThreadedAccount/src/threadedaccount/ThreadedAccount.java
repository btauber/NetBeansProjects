package threadedaccount;

import java.util.Random;

public class ThreadedAccount {
    public static void main(String[] args) {
        final Account account = new Account();
        final Random random = new Random();
        
        for(int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    while(account.getBalance() > 0) {
                        account.withdraw(random.nextInt(50));
                    }
                }
            }).start();
        }
    }
}
