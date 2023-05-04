public class TestPriority {
    // Priorities are represented by a number between 1 and 10
    public static void main(String[] args) {
        Thread counter_up = new Thread(new CounterUp(3));
        Thread counter_down = new Thread(new CounterDown(3));
        counter_up.setPriority(1);
        counter_down.setPriority(10);

        // Threads with higher priority values are usually given precedence over threads with lower priority values
        counter_up.start();
        counter_down.start();
    }

    private static class CounterUp implements Runnable {
        private final int maxCount;

        public CounterUp(int maxCount) {
            this.maxCount = maxCount;
        }

        public void run() {
            for (int i = 1; i <= maxCount; i++) {
                System.out.println("Counter Up: " + i);
            }
        }
    }

    private static class CounterDown implements Runnable {
        private final int maxCount;

        public CounterDown(int maxCount) {
            this.maxCount = maxCount;
        }

        public void run() {
            for (int i = maxCount; i >= 1; i--) {
                System.out.println("Counter Down: " + i);
            }
        }
    }
}

