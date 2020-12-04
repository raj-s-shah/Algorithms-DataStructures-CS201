import java.util.Arrays;
import java.util.Comparator;

public class VowelSort {

    public class Comp implements Comparator<String> {

        public boolean hasVowel(String word) {
            char ch = word.charAt(0);
            return "aeiou".indexOf(ch) >= 0;
        }

        @Override
        public int compare(String o1, String o2) {
            if (hasVowel(o1) && hasVowel(o2)) {
                return o1.compareTo(o2);
            }
            else if (!hasVowel(o1) && !hasVowel(o2)) {
                return o1.compareTo(o2);
            }
            else if (hasVowel(o1) && !hasVowel(o2)) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }
    public String[] sort(String[] list) {
        Arrays.sort(list, new Comp());
        return list;
    }
}