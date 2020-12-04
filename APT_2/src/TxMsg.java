import java.util.ArrayList;

public class TxMsg {
    public String getMessage(String original) {
      /*
        Split String original
        Loop through each word
            Loop through letter of each word
                take constants that only came after a vowel and add them to a string
            add the new formed word into string
        return the new string

       */

        String[] words = original.split(" ");
        ArrayList<String> nsa = new ArrayList<>();
        for (String s : words) {
            String nw = "";
            if (isVowel(s)) {
                nw = nw + s;
            }
            else {
                String[] letters = s.split("");
                boolean isAfterVowel = true;
                for (String l : letters) {
                    if (isAfterVowel && !isVowel(l)) {
                        isAfterVowel = false;
                        nw = nw + l; }
                    else if (!isVowel(l))
                        isAfterVowel = false;
                    else {
                        isAfterVowel= true;
                    }
                }
            }

            nsa.add(nw);
        }
        String ns = String.join(" ", nsa);
        return ns;
    }

    public Boolean isVowel(String lp) {
        String[] l = lp.split("");
        boolean isAllVowel = false;
        for (String s : l) {
            if (s.equals("a") ||
                    s.equals("e") ||
                    s.equals("o") ||
                    s.equals("i") ||
                    s.equals("u")) {
                isAllVowel = true;
            } else {
                isAllVowel = false;
                break;
            }


        }
    return isAllVowel;}
}
