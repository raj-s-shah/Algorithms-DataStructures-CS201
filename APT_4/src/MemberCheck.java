import javax.swing.*;
import java.util.*;
/*
        Turn each club array into HasSet
        Turn HasSet back into ArrayList
        Create a HashMap<String, Integer> places person went
        If any key has greater value than one:
                Add name return ArrayList
         Sort ArrayList
         */

public class MemberCheck {
    public String[] whosDishonest(String[] club1,
                                  String[] club2,
                                  String[] club3) {

        HashSet<String> c1 = new HashSet<>(Arrays.asList(club1));
        HashSet<String> c2 = new HashSet<>(Arrays.asList(club2));
        HashSet<String> c3 = new HashSet<>(Arrays.asList(club3));

        ArrayList<String> Sheet = new ArrayList<>();
        for (String s : c1) {
            Sheet.add(s);
        }
        for (String s : c2) {
            Sheet.add(s);
        }
        for (String s : c3) {
            Sheet.add(s);
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : Sheet) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }

        ArrayList<String> ret = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) > 1) {
                ret.add(s);
            }
        }

        Collections.sort(ret);
        String[] retu = ret.toArray(new String[ret.size()]);
        return retu;
    }
}