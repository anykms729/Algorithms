import java.lang.*;
public class Lab2_App {

        public static void main(String args[])
        {
            Lab2 t2s = new Lab2();

            System.out.println("Sum runtimes for iterative solution");
            System.out.println("***********************************************************");

            for(int i=0; i<=1000000; i= i+10000)
            {
                // nanoTime
                long startTimeNano = System.nanoTime();
                int sum = t2s.sum(i);
                long endTimeNano = System.nanoTime();
                long elapsedTime = endTimeNano - startTimeNano;

                System.out.println("Input to sum was "+ i + " with elapsed time:" + elapsedTime);
            }


            System.out.println("Sum runtimes for equation (Gauss' Formula) solution");
            System.out.println("***********************************************************");
            for(int i=0; i<=1000000; i= i+10000)
            {
                // nanoTime
                long startTimeNano = System.nanoTime();
                int sum = t2s.sum_const_time(i);
                long endTimeNano = System.nanoTime();
                long elapsedTime = endTimeNano - startTimeNano;

                System.out.println("Input to sum_const_time was "+ i + " with elapsed time:" + elapsedTime);
            }

            System.out.println("Concatenated digits solution");
            System.out.println("***********************************************************");
            String concatWord = t2s.concatDigits(2);
            System.out.println(concatWord);


            System.out.println("Registration Plate solution");
            System.out.println("***********************************************************");
            String plateNumbers = t2s.plateNumber();
            System.out.println(plateNumbers);

            System.out.println("Team-winner solution");
            System.out.println("***********************************************************");
            System.out.println (" the winner is: "  + t2s.eliminateHalf(100));
        }
}
