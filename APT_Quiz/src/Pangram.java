import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pangram {
    public String[] find(String[] phrases){
        ArrayList<String> ret = new ArrayList<>();
        for (int k = 0; k < phrases.length; k++){
            String newPhrase = phrases[k].toLowerCase();
            ArrayList<String> phraseLetters = new ArrayList<>(Arrays.asList(newPhrase.split("")));
            boolean isPangram = true;
            for (char i = 97; i < 123; i++){
                if (!phraseLetters.contains(Character.toString(i))){
                    isPangram = false;
                }
            }
            if (isPangram){
                ret.add(phrases[k]);
            }
        }
        Collections.sort(ret);
        String[] ret2 = ret.toArray(new String[0]);

        return ret2;
    }
}
