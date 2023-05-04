import java.math.BigInteger;
import java.util.Scanner;

public class Tribonacci {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int nthTrib = sc.nextInt();
        System.out.println(TribonacciFunc(nthTrib));
    }

    public static BigInteger TribonacciFunc(int n) {
        if (n == 0) {
            return new BigInteger("0");
        } else if (n == 1 || n == 2) {
            return new BigInteger("1");
        } else {
            return TribonacciFunc(n - 1).add(TribonacciFunc(n - 2)).add(TribonacciFunc(n - 3));
        }
    }
}