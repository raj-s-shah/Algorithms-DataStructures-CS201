import java.util.Arrays;
import java.util.Comparator;

public class SerialNumbers {
    public class Comp implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int sum1 = 0;
            int sum2 = 0;

            for (char s : o1.toCharArray()) {
                if (Character.isDigit(s)) {
                    sum1 += s - '0';
                }
            }
            for (char s : o2.toCharArray()) {
                if (Character.isDigit(s)) {
                    sum2 += s - '0';
                }
            }
            if (sum1 > sum2) return 1;
            else if (sum1 < sum2) return -1;
            else return o1.compareTo(o2);
        }
    }

    public String[] sortSerials(String[] numbers) {
        Arrays.sort(numbers, Comparator.comparing(String::length).thenComparing(new Comp()));
        return numbers;
    }

}