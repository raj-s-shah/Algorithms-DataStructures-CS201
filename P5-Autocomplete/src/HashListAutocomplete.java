import java.util.*;

public class HashListAutocomplete implements Autocompletor {

    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;

    public HashListAutocomplete (String[] terms, double[] weights ) {
        if (terms == null || weights == null) {
            throw new NullPointerException("One or more arguments null");
        }
        initialize(terms,weights);
    }

    @Override
    public List<Term> topMatches(String prefix, int k) {
        if(k == 0 || myMap.get(prefix) == null){
            return new ArrayList<Term>();
        }
        List<Term> all = myMap.get(prefix);
        List<Term> list = all.subList(0, Math.min(k, all.size()));
        return list;
    }

    @Override
    public void initialize(String[] terms, double[] weights) {
        myMap = new HashMap<String, List<Term>>();

        for (int k = 0; k < terms.length; k++) {
            int min = Math.min(terms[k].length(), MAX_PREFIX);
            for (int len = 0; len <= min; len++){
                if (len > terms[k].length()){
                    break;
                }
                String pre = terms[k].substring(0, len);
                myMap.putIfAbsent(pre, new ArrayList<Term>());
                myMap.get(pre).add(new Term(terms[k], weights[k]));
            }
        }
        for (String key : myMap.keySet()) {
            Collections.sort(myMap.get(key), Comparator.comparing(Term::getWeight).reversed());
        }
    }

    @Override
    public int sizeInBytes() {
        if(mySize == 0){
            for(String s : myMap.keySet()){
                List<Term> t = myMap.get(s);
                mySize += s.length() *BYTES_PER_CHAR;
                for(int i = 0; i < t.size(); i++){
                    Term a = t.get(i);
                    mySize = mySize + BYTES_PER_DOUBLE + BYTES_PER_CHAR*a.getWord().length();
                }
            }
        }
        return mySize;
    }

}
