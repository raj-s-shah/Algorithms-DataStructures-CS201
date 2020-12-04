import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SpecialSort {
    ArrayList<String> mySpecialList;

    public class Comp implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {

            if (mySpecialList.contains(o1) && !mySpecialList.contains(o2)) {
                return -1;
            }
            if (!mySpecialList.contains(o1) && mySpecialList.contains(o2)) {
                return 1;
            }

            return o1.compareTo(o2);
        }
    }
    public String[] sort(String[] data, String[] special) {
        mySpecialList = new ArrayList<>(Arrays.asList(special));
        Arrays.sort(data, new Comp());

        return data;
    }
}