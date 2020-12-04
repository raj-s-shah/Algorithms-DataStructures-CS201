import java.util.Arrays;
import java.util.TreeSet;

public class SetAside {
    public String common(String[] list) {
        TreeSet<String> set = new TreeSet<>();
        String[] base = list[0].split(" ");
        for (String s : base) {
            set.add(s);
        }
        for (int k = 1; k < list.length; k++){
            String[] words = list[k].split(" ");
            set.retainAll(Arrays.asList(words));
        }
        String ret = String.join(" ", set);
        return ret;
    }
}