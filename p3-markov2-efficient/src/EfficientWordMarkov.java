import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram,ArrayList<String>> myMap;

    public EfficientWordMarkov() {
        this(3);
    }
    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
    }


    @Override
    public void setTraining(String text) {
        myWords = text.split("\\s+");
        myMap.clear();

       for (int i = 0; i < myWords.length - myOrder + 1; i++){
           WordGram key = new WordGram(myWords, i, myOrder);

           if (! myMap.keySet().contains(key)) {
               myMap.put(key, new ArrayList<String>());
           }

           String value;
           if (i == myWords.length - myOrder) {
               value = PSEUDO_EOS;
           }

           else {
               WordGram temp = new WordGram(myWords, i + myOrder, 1);
               value = temp.toString();
           }

           myMap.get(key).add(value);
       }


    }

    @Override
    public ArrayList<String> getFollows(WordGram kGram) {
        if (!(myMap.containsKey(kGram))) {
            throw new NoSuchElementException(kGram + " not in map");
        }
        else {
            return myMap.get(kGram);
        }
    }
}
