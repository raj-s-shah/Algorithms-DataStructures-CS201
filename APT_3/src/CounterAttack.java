import java.util.HashMap;

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        int[] ret = new int[words.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (String s: str.split(" ")) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }
        for (int k=0; k < words.length; k++) {
            ret[k] = map.getOrDefault(words[k], 0);
        }
        return ret;
    }
}
