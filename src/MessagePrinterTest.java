// NEW: Thread not yet started
// RUNNABLE: Executing in JVM
// BLOCKED: Blocked waiting for a monitor lock
// WAITING: Wait indefinitely for another thread to perform a particular action
// TIMED_WAITING: Wait indefinitely for another thread to perform a particular action up to specified time
// TERMINATED

public class MessagePrinterTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MessagePrinter("Hello", 5);
        Thread t2 = new MessagePrinter("Hello 2", 5);
        t1.start();
        t2.start();
        try {
            // The Thread.join method allows one thread to wait for the completion of another
            t1.join();
        } catch (InterruptedException e) {
            // Way for thread support its own interruption
            System.out.println("I'm stopped... I wasn't done yet");
            return;
        }
        System.out.println("All messages are printed");
    }

    public static class MessagePrinter extends Thread {
        String message;
        int count;

        public MessagePrinter(String message, int count) {
            this.message = message;
            this.count = count;
        }

        @Override
        public void run() {
            for (int i=0; i<count; i++){
                System.out.println(message);
            }
        }
    }
}
