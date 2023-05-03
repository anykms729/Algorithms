public class Factorial extends Thread {
    int result;
    int n;

    Factorial(int n) {
        this.n = n;
    }

    public void run() {
        result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    public int getResult(){
        return result;
    }


    class FactorialApp{
        public static void main(String[] args) {
            Factorial fn = new Factorial(5);
            fn.start();
            try {
                fn.join();
            }catch (InterruptedException e){}
            System.out.println(fn.getResult());
        }
    }
}
