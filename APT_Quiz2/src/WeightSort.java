import java.util.Arrays;
import java.util.Comparator;

public class WeightSort {
    public class Comp implements Comparator<String> {

        public int turnLetterToNum(char letter) {
            int weight = letter - 64;
            return weight;
        }

        public int sum (String o) {
            int sum = 0;
            for (char letter : o.toCharArray()) {
                sum += turnLetterToNum(letter);
            }
            return sum;
        }

        @Override
        public int compare(String o1, String o2) {
            int sum1 = sum(o1);
            int sum2 = sum(o2);

            if (sum1 > sum2) return 1;
            if (sum1 < sum2) return -1;
            return o1.compareTo(o2);

        }
    }
    public String[] sort(String[] strs) {
        Arrays.sort(strs, new Comp());
        return strs;
    }
}