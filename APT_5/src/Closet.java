import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Closet {
    public String anywhere(String[] list) {
        TreeSet<String> uniques = new TreeSet<>();

        for (String s : list) {
            String[] words = s.split(" ");

            for (String i : words){
                uniques.add(i);
            }
        }
        String ret = String.join(" ", uniques);
        return ret;
    }
}