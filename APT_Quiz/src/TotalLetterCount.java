public class TotalLetterCount {
    public int total(String[] words, String letter) {
        int ret = 0;
        for (int k = 0; k < words.length; k++) {
            String[] wordLetters = words[k].split("");
            for (String wordLetter : wordLetters) {
                if (wordLetter.equals(letter)) {
                    ret += k;
                }
            }
        }
        return ret;
    }
}
