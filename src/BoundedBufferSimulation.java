import java.util.LinkedList;
import java.util.Queue;

public class BoundedBufferSimulation {

    public static void main(String args[]) {
        Buffer sharedData = new Buffer(3);
        Thread p0 = new Thread(new Consumer(0, sharedData));

        Thread p1 = new Thread(new Producer(1, sharedData));
        Thread p2 = new Thread(new Producer(2, sharedData));
        Thread p3 = new Thread(new Producer(3, sharedData));
        Thread p4 = new Thread(new Producer(4, sharedData));
        Thread p5 = new Thread(new Producer(5, sharedData));

        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }

    public static class Buffer {
        int size;
        Queue<String> producedData;
        Semaphore useQueue;
        Semaphore fullCount;
        Semaphore emptyCount;

        Buffer(int size) {
            this.size = size;
            producedData = new LinkedList<>(); // this is the data holder

            // semaphores to control access to the queue for different operations
            useQueue = new Semaphore(1);
            fullCount = new Semaphore(0);
            emptyCount = new Semaphore(size);
        }


        public void insert(String message) {

            emptyCount.acquire();
            useQueue.acquire();

            //add a message to the queue
            producedData.add(message);

            useQueue.release();
            fullCount.release();
        }

        public String remove() {

            fullCount.acquire();
            useQueue.acquire();

            String data = producedData.poll();

            useQueue.release();
            emptyCount.release();

            return data;
        }
    }

    public static class Consumer implements Runnable {
        private int id;
        private Buffer sharedData;


        Consumer(int id, Buffer sharedData) {
            this.id = id;
            this.sharedData = sharedData;
        }

        public void run() {

            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }


                String message = sharedData.remove();
                System.out.println("I am consumer number: " + id + " This is the message I read: " + message);
            }

        }
    }

    public static class Producer implements Runnable {
        private int id;
        private Buffer sharedData;


        Producer(int id, Buffer sharedData) {
            this.id = id;
            this.sharedData = sharedData;
        }

        public void run() {

            while (true) {
                try {
                    Thread.sleep(2000 * id);
                } catch (InterruptedException e) {
                }

                String message = "I am producer number: " + id + " this is an inserted message";
                sharedData.insert(message);
            }

        }
    }

    public static class Semaphore {
        private int counter;

        Semaphore(int size) {
            counter = size; // here I am selecting how many threads can occupy this semaphore at once
        }

        public synchronized void acquire() {
            while (counter == 0) {
                try {
                    wait(); // wait for the counter to increase by one
                } catch (InterruptedException e) {
                }
            }
            counter--;
        }

        public synchronized void release() {
            counter++;
            notify(); // this will message the threads that are waiting and tell them to proceed to the next line
        }
    }
}
