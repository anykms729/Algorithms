import java.util.*;

public class Lab2 {
    public int sum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    /*
     * I have only implemented the solution to the sum of all numbers.
     * I am leaving it as an exercise for someone to solve an equation for the
     * sum of all even numbers
     */
    public int sum_const_time(int n) {
        int sum = n * (n + 1) / 2;
        return sum;
    }

    public String concatDigits(int n) {
        StringBuffer strB = new StringBuffer();
        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= n; j++) {
                strB.append(Integer.toString(i));
                strB.append(Integer.toString(j));
                strB.append(",");
            }
        }
        String finalConcat = strB.toString();
        return finalConcat;
    }

    public String plateNumber() {
        StringBuffer strB = new StringBuffer();
        // making an array of characters to store alphabetical and numeric characters
        char[] possible_letters = new char[36];


        int letter_index = 0;// this index will keep track of the char array
        //use the loop below to go through all upper case letters
        for (int letter = 'A'; letter < 'A' + 26; letter++) {
            possible_letters[letter_index++] = (char) letter;
        }

        // go through all numeric values and add to char array
        for (int num = 0; num <= 9; num++) {
            possible_letters[letter_index++] = (char) (num + '0');
        }


        // a nested loop for each character in the 4 digit plate number
        for (int letter_1 = 0; letter_1 < possible_letters.length; letter_1++) {
            for (int letter_2 = 0; letter_2 < possible_letters.length; letter_2++) {
                for (int letter_3 = 0; letter_3 < possible_letters.length; letter_3++) {
                    for (int letter_4 = 0; letter_4 < possible_letters.length; letter_4++) {
                        strB.append(possible_letters[letter_1] + "" + possible_letters[letter_2] + "" + possible_letters[letter_3] + possible_letters[letter_4] + ",");
                    }
                }
            }
        }
        return strB.toString();
    }

    public int eliminateHalf(int team_size) {
        int round_number = 1;
        int team_one_lower = 1;
        int team_one_higher = team_size / 2;
        int team_two_lower = (team_size / 2) + 1;
        int team_two_higher = team_size;

        int last_winner = 1;

        while (team_one_lower != team_two_higher) {
            team_size /= 2;
            System.out.println("This is round number: " + round_number++);
            double random_chance = Math.random();

            System.out.println("Group 1: " + team_one_lower + "-" + team_one_higher);
            System.out.println("Group 2: " + team_two_lower + "-" + team_two_higher);

            // lower team wins
            if (random_chance > 0.5) {
                System.out.println("Group 2 is eliminated. Group 1 will remain to the next round.");
                // team_one_lower = stays the same;
                team_two_higher = team_one_higher;
                team_one_higher = (team_one_lower + team_one_higher) / 2;
                team_two_lower = team_one_higher + 1;
                last_winner = team_one_lower;
            } else {
                System.out.println("Group 1 is eliminated. Group 2 will remain to the next round.");
                //team_two_higher = stays the same;
                team_one_lower = team_two_lower;
                team_one_higher = (team_two_lower + team_two_higher) / 2;
                team_two_lower = team_one_higher + 1;
                last_winner = team_two_higher;
            }
        }
        return last_winner;
    }
}
