public class YieldingThread extends Thread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");
        thread1.start();
        thread2.start();
    }

    private static class MyRunnable implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                if (i == 5) {
                    // Voluntarily give up the processor
                    Thread.yield();
                }
            }
        }
    }
}


