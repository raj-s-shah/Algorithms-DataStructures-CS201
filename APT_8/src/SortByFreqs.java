import java.util.*;

public class SortByFreqs {
    public String[] sort(String[] data) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(data));
        TreeSet<String> set = new TreeSet<>(list);
        ArrayList<String> sortedList = new ArrayList<>(set);

        Comparator<String> comp;
        comp = Comparator.comparing((a)->Collections.frequency(list, a));
        Collections.sort(sortedList, comp.reversed());

        return sortedList.toArray(new String[0]);
    }
}