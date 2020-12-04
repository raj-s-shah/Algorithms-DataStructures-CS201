import java.util.*;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        int ret = 0;
        int[] headlineCounts = getCounts(headlines);
        for (String s : messages) {
            int[] messageCounts = getCounts(s.split(" "));
            boolean valid = false;
            for (int k = 0; k < messageCounts.length; k++) {
                if (!(messageCounts[k] <= headlineCounts[k])) {
                    break;
                }
                else if (messageCounts[k] <= headlineCounts[k] &&
                        (k == (messageCounts.length -1))) {
                        valid = true;
                }
            }
            if(valid) {
                ret += 1;
            }

        }
        return ret;
    }
    private int[] getCounts(String[] strings){
        int[] counts = new int[123];
        for (String s: strings) {
            for(char ch : s.toLowerCase().toCharArray()){
                counts[ch] += 1;
            }
        }
        return counts;
    }
}