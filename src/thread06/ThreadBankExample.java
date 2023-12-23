package thread06;

public class ThreadBankExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i<5; i++) {
                account.deposit(200); // burda account.withdraw deseydik,
                //withdraw methodunu synchronized yapmalıydık
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3 ; i++ ) {
                account.withdraw(300);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
