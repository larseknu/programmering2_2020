package no.hiof.larseknu.traader;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadCounter threadCounter = new ThreadCounter(1000);
        RunnableCounter runnableCounter = new RunnableCounter(1000);
        Thread runnableThread = new Thread(runnableCounter);

        threadCounter.start();
        runnableThread.start();

        threadCounter.join();
        runnableThread.join();

        System.out.println("Finished!");
    }
}
