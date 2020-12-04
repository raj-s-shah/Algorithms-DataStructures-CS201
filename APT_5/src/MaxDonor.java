import java.util.HashMap;

public class MaxDonor {
    public String generous(String[] orgs, int[] amount) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int k = 0; k < orgs.length; k++) {
            map.putIfAbsent(orgs[k], 0);
            map.put(orgs[k], map.get(orgs[k]) +amount[k]);
            if (map.get(orgs[k]) > max) {
                max = map.get(orgs[k]);
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s) == max) {
                return s;
            }
        }
        return orgs[0];
    }
}