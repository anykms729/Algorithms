import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        LargestNumberArray();
    }

    public static void LargestNumberArray(){
        int[] numbers = new int[1000];
        for (int numberIndex=0; numberIndex<numbers.length;numberIndex++){
            numbers[numberIndex] = (int) (Math.random()*800);
        }
        long start_time = System.nanoTime();
        // assume at the beginning the first number is the largest
        int largestNumber = numbers[0];
        // Now I will prove otherwise if this is not true
        for(int currentNumber : numbers){
            // overwrite the largest number if a larger one is found
            if(currentNumber > largestNumber){
                largestNumber = currentNumber;
            }
        }

        System.out.println("Largest Number: "+largestNumber);

        long end_time = System.nanoTime();

        long elapsed_time = end_time - start_time;
        System.out.println("Elapsed time: "+elapsed_time);
    }

    public static void LargeNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input num1");
        int num1 = sc.nextInt();
        System.out.println("Input num2");
        int num2 = sc.nextInt();

//        long start_time = System.currentTimeMillis();
        long start_time = System.nanoTime();
        if (num1 > num2) {
            System.out.println("Largest number: "+num1);
        } else {
            System.out.println("Largest number: "+num2);
        }
//        long end_time = System.currentTimeMillis();
//        long duration = end_time - start_time;

        long end_time = System.nanoTime();
        long duration = end_time - start_time;
        System.out.println("Running time: "+duration+" nanoTime");
    }
}
