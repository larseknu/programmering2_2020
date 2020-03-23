package no.hiof.larseknu.manythreads;

public class TransactionHandler implements Runnable {
    private BankAccount bankAccount;

    public TransactionHandler(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (bankAccount) {
                int startBalance = bankAccount.getBalance();

                bankAccount.insert(100);

                pauseThread(150);

                int endBalance = bankAccount.getBalance();

                System.out.println(String.format("Start balance: %d - End balance %d %s", startBalance, endBalance, Thread.currentThread().getName()));
            }
        }
    }

    private void pauseThread(int timeMs)  {
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
