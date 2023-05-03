import java.math.BigInteger;
import java.util.Scanner;

public class RecursionApp {
    static BigInteger[] memoizeSolutions;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n_Factorial = factorial(n);
        System.out.println(n_Factorial);

        printStar(n);

        int[] arr = {1, 3, 5, 20, 14};
        System.out.println("The sum with the iterative solution");
        System.out.println(iterative_Sum(arr));

        System.out.println("The sum with the recursive solution");
        System.out.println(recursive_Sum(arr, n));

        boolean test1 = recursive_Search(arr, 5, 0);
        boolean test2 = recursive_Search(arr, 200, 0);

        System.out.println("Result of test 1: " + test1);
        System.out.println("Result of test 2: " + test2);


        int nth_Fib = iterative_Fibonacci(n);

        System.out.println("the " + n + "th fibonacci number is: " + nth_Fib);

        memoizeSolutions = new BigInteger[1000];

        BigInteger fib = memoizeRecursiveFibonacci(50);
        System.out.println("50th fib is:" + fib);
    }

    static BigInteger memoizeRecursiveFibonacci(int n) {
        BigInteger zero = new BigInteger(String.valueOf(0));

        if (n == 1 || n == 2) {
            memoizeSolutions[n] = new BigInteger(String.valueOf(1));
            return memoizeSolutions[n];
        } else if (memoizeSolutions[n] != null) {
            return memoizeSolutions[n];
        }
        // If "n" is not 1 or 2, and "nth" index is null (means no value)
        else {
            memoizeSolutions[n] = memoizeRecursiveFibonacci(n - 1).add(memoizeRecursiveFibonacci(n - 2));
            return memoizeSolutions[n];
        }
    }

    // Check Logic
    static int recursive_Fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return recursive_Fibonacci(n - 1) + recursive_Fibonacci(n - 2);
        }
    }

    static int iterative_Fibonacci(int n) {
        int current = 1;
        int previous = 1;

        for (int Index = 2; Index < n; Index++) {
            int temp = current;

            current = current + previous;

            previous = temp;
        }
        return current;
    }

    static boolean recursive_Search(int[] arr, int query, int index) {
        if (index >= arr.length) {
            return false;
        } else if (arr[index] == query) {
            return true;
        } else return recursive_Search(arr, query, index + 1);
    }

    static int recursive_Sum(int[] arr, int index) {
        // Base case
        if (index >= arr.length) {
            return 0;
        } else {
            return arr[index] + recursive_Sum(arr, index + 1);
        }
    }

    static int iterative_Sum(int[] arr) {
        int sum = 0;
        for (int index = 0; index < arr.length; index++) {
            sum = sum + arr[index];
        }
        return sum;
    }

    static void printStar(int nth_star) {
        if (nth_star == 0) {
            System.out.println("0th star has no meaning");
        } else {
            System.out.print("*" + " ");
            printStar(nth_star - 1);
        }
    }

    static int factorial(int n) {
        if (n == 0) return 1;
        else return n * factorial(n - 1);
    }
}
