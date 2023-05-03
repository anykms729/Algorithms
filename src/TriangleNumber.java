import java.math.BigInteger;

public class TriangleNumber {
    public static void main(String[] args) {
        System.out.println(computeNumber(6));
    }

    public static BigInteger computeNumber(int n) {
        n = (n * (n + 1)) / 2;
        return BigInteger.valueOf(n);
    }
}
