import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimpleWordGame {
    public int points(String[] player,
                      String[] dictionary) {
        int ret = 0;
        Set<String> words = new HashSet<>(Arrays.asList(player));
        ArrayList<String> dic = new ArrayList<>(Arrays.asList(dictionary));
        for (String s: words) {
            if (dic.contains(s)) {
                ret = (s.length() * s.length()) + ret;
            }
        }
        return ret;
    }
}