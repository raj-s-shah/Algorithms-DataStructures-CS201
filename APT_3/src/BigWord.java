import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;

public class BigWord {
    public String most(String[] sentences) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> check = new ArrayList<>();
        for (String s : sentences) {
            String[] words = s.split(" ");
            for (String t : words) {
                String r = t.toLowerCase();
                map.putIfAbsent(r, 0);
                map.put(r, map.get(r) + 1);
                if (!check.contains(r)) {
                    check.add(r);
                }
            }
        }
        int max = 0;
        int index = 0;
        for (int k = 0; k < check.size(); k++) {
            if (map.get(check.get(k)) > max) {
                max = map.get(check.get(k));
                index = k;
                }

            }
        return check.get(index);
        }
    }
