package no.hiof.larseknu.manythreads;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BankAccount yourBankAccount = new BankAccount("9001", 1000);
        BankAccount myBankAccount = new BankAccount("9001", 1000);

        manualThread(yourBankAccount);

        executorThreads(myBankAccount);
    }

    public static void executorThreads(BankAccount yourBankAccount) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            TransactionHandler transactionHandler = new TransactionHandler(yourBankAccount);

            executorService.submit(transactionHandler);
        }

        executorService.shutdown();

        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("End balance: " + yourBankAccount.getBalance());
    }

    private static void manualThread(BankAccount yourBankAccount) throws InterruptedException {
        List<Thread> threads = new ArrayList();

        for (int i = 0; i < 3; i++) {
            TransactionHandler transactionHandler = new TransactionHandler(yourBankAccount);

            threads.add(new Thread(transactionHandler));

            threads.get(i).start();
        }

        //for (Thread aThread : threads)
        //    aThread.join();

        System.out.println("End balance: " + yourBankAccount.getBalance());
    }
}
