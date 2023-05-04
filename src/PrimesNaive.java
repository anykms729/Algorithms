import java.util.Scanner;
public class PrimesNaive {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean prime = isPrime(n); // this will return a boolean stating if n is prime or not prime. 

        System.out.println("is prime? " + prime);

        boolean prime2 = isPrimeSieve(n);

        System.out.println("is prime sieve? " + prime2);
    }

    /**
     * this will return a boolean stating if n is prime or not prime. 
     */
    static boolean isPrime(int n){

        if(n <=  1){
            return false;
        }

        // if we check all numbers between 2 and n and none divive evenly, then it is prime.
        for(int check = 2; check <= (int)Math.sqrt(n); check++){
            if(n % check==0){
                return false;
            }
        }

        return true;

    }

    /**
     * This method will check all the numbers between 2 and n
     * to see if they are prime, but this time it will use the prime
     * sieve algorithm
     */
    static boolean isPrimeSieve(int n){

        boolean [] sieve = new boolean [n + 1];

        sieve[0] = false;
        sieve[1] = false;

        // set all values to true and then prove they are not prime
        for(int check = 2; check <= n; check++){
            sieve[check] = true;
        }


        // if the current value is true then it is prime,
        // when we find a prime we set all values in the array divisible by it to false
        for(int currentValue = 2; currentValue <= (int)Math.sqrt(n); currentValue++){

            if(sieve[currentValue] == true){
                for(int setNotPrime = currentValue + currentValue; setNotPrime <= n; setNotPrime+= currentValue){
                    sieve[setNotPrime] = false;
                }
            }

        }

        return sieve[n];

    }
}