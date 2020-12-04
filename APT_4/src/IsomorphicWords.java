import java.util.HashMap;

public class IsomorphicWords {
    public int countPairs(String[] words) {
        int ret = 0;
        for (int k = 0; k < words.length; k++){
            for (int j = k + 1; j < words.length; j++ ) {
                if (iso(words[j]).equals(iso(words[k]))) {
                    ret += 1;
                }
            }

        }
        return ret;
    }
    public String iso(String string) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] charArray = string.toCharArray();
        char[] newCharArray = new char[charArray.length];

        char current = 'a';
        for (int k = 0; k < charArray.length; k++) {

            if(!(map.keySet().contains(charArray[k]))) {
                map.putIfAbsent(charArray[k], current);
                current += 1;
            }

            newCharArray[k] = map.get(charArray[k]);

        }
        String ret = new String(newCharArray);
        return ret;
    }
}