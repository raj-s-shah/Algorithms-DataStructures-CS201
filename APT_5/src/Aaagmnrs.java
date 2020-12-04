import java.util.*;

public class Aaagmnrs {
    public String[] anagrams(String[] phrases) {
       ArrayList<String> ret = new ArrayList<>();
       ret.addAll(Arrays.asList(phrases));

       for (int k = 0; k < phrases.length; k++){
           char[] word1 = phrases[k].toLowerCase().replaceAll("\\s+","").toCharArray();
           Arrays.sort(word1);
           for (int j = k + 1; j < phrases.length; j++ ) {
               char[] word2 = phrases[j].toLowerCase().replaceAll("\\s+","").toCharArray();
               Arrays.sort(word2);
               if (Arrays.equals(word1, word2)) {
                   ret.remove(phrases[j]);
               }
           }
       }

       String[] ret2 = new String[ret.size()];
       for (int k = 0; k < ret.size(); k++) {
           ret2[k] = ret.get(k);
       }
       return ret2;
    }
}