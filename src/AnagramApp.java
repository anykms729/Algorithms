import java.util.HashMap;

public class AnagramApp {
    public static void main(String args[]) {
        System.out.println(isAnagram("I AM LORD VOLDEMORT", "TOM MARVOLO RIDDLE"));
    }


    public static boolean isAnagram(String word1, String word2) {

        // remove all spaces from the words as we have decided based on the test
        // cases that they do not matter
        word1 = word1.replaceAll(" ", "");
        word2 = word2.replaceAll(" ", "");


        // two words can only be anagrams if they have the same number of letters
        if (word1.length() != word2.length()) {
            return false;
        }


        // use a hash map to count the number of each letter in the string
        HashMap<String, Integer> letters = new HashMap<>();

        // use a loop to iterate through each letter in the first string
        for (int l1 = 0; l1 < word1.length(); l1++) {

            // this selects one character at a time from the string
            String queryLetter = word1.charAt(l1) + "";

            // here we check if the letter has already been added to the hashmap
            if (letters.containsKey(queryLetter)) {
                //if it has been seen before then we increment the number of times we have seen it
                letters.put(queryLetter, letters.get(queryLetter) + 1);
            } else {
                // if this is the first instance then we set the count to 1 for that letter
                letters.put(queryLetter, 1);
            }
        }

        /*
        now we go through the second word and repeat the steps above except
        if we encounter a letter already in the hashmap then we decrease the count by 1.

            If the count goes below 0 then there are more instances of that letter in the second
            word so return false.

            If that letter is not in the hashmap then we return false because the second word has
            letters the first does not.

         */
        for (int l2 = 0; l2 < word2.length(); l2++) {
            String queryLetter = word2.charAt(l2) + "";

            if (letters.containsKey(queryLetter)) {
                letters.put(queryLetter, letters.get(queryLetter) - 1);
                if (letters.get(queryLetter) < 0) {
                    return false;
                }
            } else {
                return false;
            }

        }

        /*
         * If we have gotten this far without returning false then the two words
         * are anagrams. We therefore return true.
         *
         * This has a big O complexity of order N. This is because each loop is dependent
         * on the size of each word. The hashmap has a constant retrieval/lookup time.
         *
         * However if there was an ever growing alphabet that we had to account for, for each word
         * then the hashmap deteriorates its performance. Given the test cases, we may be able to
         * discount this possibility. However a note on this for future maintanence (if used within
         * a larger system) would be useful for future development.
         *
         * Hashmaps are usually really useful for small interview type questions. They often are
         * self contained and the test cases don't usually account for things that happen in the
         * big bad world.
         */

        return true;
    }
}
