import java.util.Scanner;

public class EggTimerApp {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        EggTimer et = new EggTimer();

        et.start();
        sc.nextLine();
        et.terminate();
    }

    public static class EggTimer extends Thread {

        private volatile boolean go;

        EggTimer() {
            go = true;
        }

        public void run() {
            int counter = 0;

            while (counter <= 60 && go) {
                System.out.println(counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                counter++;
            }
        }


        public void terminate() {
            go = false;
        }
    }
}
