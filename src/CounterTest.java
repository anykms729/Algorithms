public class CounterTest {
    public static void main(String[] args) {
        Thread counter_up = new Thread(new CountUp(1, 5));
        Thread counter_down = new Thread(new CountDown(10, 6));
        counter_up.start();
        counter_down.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // To check if the thread is still running, returns true or false
        if (counter_down.isAlive()) {
            // An interrupt is an indication to a thread that it should stop what it is doing and do something else
            counter_down.interrupt();
        }
    }

    private static class CountUp implements Runnable {
        private final int start;
        private final int end;

        public CountUp(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i <= end; i++) {
                System.out.println("Counting up: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    private static class CountDown implements Runnable {
        private final int start;
        private final int end;

        public CountDown(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i >= end; i--) {
                System.out.println("Counting down: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}