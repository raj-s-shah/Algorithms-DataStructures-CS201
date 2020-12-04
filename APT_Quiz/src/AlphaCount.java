
import java.util.HashMap;
import java.util.TreeSet;

public class AlphaCount {
    public int[] sizing(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String key : words){
            map.putIfAbsent(key, 0);
            map.put(key, map.get(key) + 1);
        }

        int[] ret = new int[map.keySet().size()];

        TreeSet<String> orderedKeys = new TreeSet<>();
        for (String key : map.keySet()){
            orderedKeys.add(key);
        }

        Object[] keys = orderedKeys.toArray();
        for (int k = 0; k < keys.length; k++){
            ret[k] = map.get(keys[k]);
        }

        return ret;
    }
}
