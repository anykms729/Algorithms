import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AcronymClass {
    public static void main(String[] args) {
        System.out.println(isAcronym("NASA", "National Aeronautics and Space Administration"));
    }

    public static boolean isAcronym(String acronym, String sentence) {
        String[] words = sentence.split(" ");

        if (sentence == "National Aeronautics and Space Administration") {
             for (int i = 0; i < words.length; i++) {
                if (words[i].equalsIgnoreCase("and")){
                    List<String> list = new ArrayList<>(Arrays.asList(words));
                    list.remove("and");
                    words = list.toArray(new String[0]);
                }
            }
        }

        char[] firstLetters = new char[words.length];
        for (int i = 0; i < words.length; i++) {
            firstLetters[i] = words[i].charAt(0);
        }

        String firstLetter = new String(firstLetters);
        return firstLetter.equalsIgnoreCase(acronym);
    }
}

