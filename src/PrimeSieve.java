import java.util.ArrayList;

public class PrimeSieve {

    public static void main(String[] args) {
        int primes = isPrimeSegmented(100);
        System.out.println(primes);
    }

    static int isPrimeSegmented(int n) {
        // check primes up to sqrt of n
        int limit = (int) (Math.floor(Math.sqrt(n)) + 1);
        ArrayList<Integer> nSqrtPrimes = isPrime(limit);

        // check the primes between the sqrt(n) ranges
        int low = limit;
        int high = limit * 2;
        int counter = nSqrtPrimes.size();

        while (low < n) {
            if (high > n) {
                high = n;
            }

            // store current range of numbers in this cache array
            // this will be overwritten once all primes are found in this range 
            boolean[] numberCache = new boolean[limit + 1];

            for (int i = 0; i < numberCache.length; i++) {
                numberCache[i] = true;
            }

            // use simple sieve technique to check if primes in list divide into 
            // the current set of numbers in our range
            for (int prime : nSqrtPrimes) {

                // get the lowest disible number for prime
                int lowestDiv = (int) (Math.floor(low / prime) * prime);
                if (lowestDiv < low) {
                    lowestDiv += prime;
                }

                for (int marked = lowestDiv; marked < high; marked += prime) {
                    numberCache[marked - low] = false;

                }

            }

            for (int i = low; i < high; i++) {
                if (numberCache[i - low]) {
                    counter++;
                }
            }
            low = low + limit;
            high = high + limit;
        }
        return counter;
    }

    static ArrayList<Integer> isPrime(int maxValue) {
        boolean[] allNums = new boolean[maxValue + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int currentIndex = 0; currentIndex < allNums.length; currentIndex++) {
            allNums[currentIndex] = true;
        }

        allNums[0] = false;
        allNums[1] = false;


        for (int currentIndex = 2; currentIndex < maxValue; currentIndex++) {
            if (allNums[currentIndex]) {
                primes.add(currentIndex);
                for (int resetIndex = currentIndex + currentIndex; resetIndex <= maxValue; resetIndex += currentIndex) {
                    allNums[resetIndex] = false;
                }
            }
        }

        return primes;
    }
}