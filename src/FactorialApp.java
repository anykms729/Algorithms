public class FactorialApp {

    public static void main(String args[]) {

        Result res = new Result();
        Factortial fn = new Factortial(5, res);
        fn.start();


        System.out.println("Soon we will see the result of fn");

        try {
            fn.join();
        } catch (InterruptedException e) {
        }


        System.out.println(res.getResult());

    }


    public static class Factortial extends Thread {

        Result result;
        int n;

        Factortial(int n, Result result) {
            this.n = n;
            this.result = result;
        }

        public void run() {
            int facn = 1;

            for (int i = 1; i <= n; i++) {
                facn = facn * i;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

            }

            result.setResult(facn);
        }
    }

    public static class Result {
        int result = -1;

        public void setResult(int n) {
            result = n;
        }

        public int getResult() {
            return result;
        }

    }
}
