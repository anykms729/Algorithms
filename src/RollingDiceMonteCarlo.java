public class RollingDiceMonteCarlo {

    /*
     * Simulate two dice rolling 10,000 times
     * and we want a probability distribution
     * of how likely it is to roll a sum for
     * these two dice.
     *
     * Assume the dice are fair and six sided.
     */

    public static void main (String [] args){

        // accounts for likelihoods of rolling a sum of numbers
        int [] diceRollCounter = new int [13];

        for(int rollingExperience=0; rollingExperience < 1000000; rollingExperience++){

            // simulate rolling two dice
            int die1 = (int)((Math.random() * 6) + 1);
            int die2 = (int)((Math.random() * 6) + 1);

            // add their sum together
            int sumResult = die1 + die2;

            // each time a sum occurs, increase the corresponding index
            // in our array by 1.
            diceRollCounter[sumResult] = diceRollCounter[sumResult] + 1;


        }

        int index = 0;
        for(int rollFrequency : diceRollCounter){

            System.out.print("Likelihood of rolling a " + index + ": ");
            System.out.println((int)((rollFrequency / 10000)) + "%");
            index++;
        }
    }
}
