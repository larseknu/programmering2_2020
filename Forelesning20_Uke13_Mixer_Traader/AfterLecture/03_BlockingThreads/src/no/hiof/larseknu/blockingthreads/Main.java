package no.hiof.larseknu.blockingthreads;

public class Main {

    public static void main(String[] args) {
        String resource1 = "Valueable resource 1";
        String resource2 = "Valueable resource 2";


        // Tråd 1 prøver å låse ressurs 1, så ressurs 2
        Thread traad1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Låser viktigRessurs1 for behandling
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource1);

                    pauseThread(100);

                    System.out.println(Thread.currentThread().getName() + " trying to lock " + resource2);
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread().getName() + " locked " + resource2);
                    }
                }
            }
        });


        // Tråd 2 prøver å låse ressurs2, så ressurs1
        Thread traad2 = new Thread(() -> {
            // Låser viktigRessurs2 for behandling
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource2);

                pauseThread(100);

                System.out.println(Thread.currentThread().getName() + " trying to lock " + resource1);
                // Prøver å låse viktigRessurs1
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource1);
                }
            }
        });


        traad1.start();
        traad2.start();
    }

    private static void pauseThread(int timeMs) {
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
