public class DiningPhilosopherSimulation {
    public static void main(String args[]) {
        Semaphore chopsticks[] = new Semaphore[5];
        Thread philosophers[] = new Thread[5];

        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Thread(new Philosopher(i, chopsticks));
            philosophers[i].start();
        }
    }

    public static class Philosopher implements Runnable {
        int id;
        Semaphore chopsticks[];

        public Philosopher(int id, Semaphore[] chopsticks) {
            this.id = id;
            this.chopsticks = chopsticks;
        }

        @Override
        public void run() {

            while (true) {
                // pick up left chopstick
                chopsticks[id].acquire();
                // pick up right chopstick
                chopsticks[(id + 1) % chopsticks.length].acquire();

                System.out.println("Philosopher number: " + id + " is eating now ");
                // simulate eating
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }

                chopsticks[id].release();
                chopsticks[(id + 1) % chopsticks.length].release();

                System.out.println("Philosopher number: " + id + " is finished eating and will now sleep ");

                // simulate sleeping
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class Semaphore {
        int state;

        public Semaphore(int size) {
            state = size;
        }

        //synchronized ensures this method is only ran by one thread at a single instance of time
        public synchronized void acquire() {
            while (state == 0) {
                try {
                    //Thread.sleep(1000);
                    wait(); // any threads running this method must wait until they are notified they can run again
                } catch (InterruptedException e) {
                }
            }
            state--;
        }

        public synchronized void release() {
            state++;
            notify();
        }

    }
}

