import java.util.ArrayList;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        ArrayList<String> ret = new ArrayList<>();
        for (String s : list) {
            if (s.length() >= minLength && !ret.contains(s)) {
                ret.add(s);
            }
        }
        String[] ans = new String[ret.size()];
        for (int k = 0; k < ret.size(); k++) {
            ans[k] = ret.get(k);
        }
        return ans;
    }
}