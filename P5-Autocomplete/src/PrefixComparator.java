import java.util.Comparator;

/**
 * Factor pattern for obtaining PrefixComparator objects
 * without calling new. Users simply use
 *
 *     Comparator<Term> comp = PrefixComparator.getComparator(size)
 *
 * @author owen astrachan
 * @date October 8, 2020
 */
public class PrefixComparator implements Comparator<Term> {

    private int myPrefixSize; // size of prefix

    /**
     * private constructor, called by getComparator
     * @param prefix is prefix used in compare method
     */
    private PrefixComparator(int prefix) {
        myPrefixSize = prefix;
    }


    /**
     * Factory method to return a PrefixComparator object
     * @param prefix is the size of the prefix to compare with
     * @return PrefixComparator that uses prefix
     */
    public static PrefixComparator getComparator(int prefix) {
       return new PrefixComparator(prefix);
    }


    @Override
    public int compare(Term v, Term w) {
        if (v.getWord().length() < myPrefixSize || w.getWord().length() < myPrefixSize){
           return TooSmall(v, w, 0);
        }
        String vPreFix = v.getWord().substring(0, myPrefixSize);
        String wPreFix = w.getWord().substring(0, myPrefixSize);

        return vPreFix.compareTo(wPreFix);
    }

    private int TooSmall (Term v, Term w, int index) {
        if (index == Math.min(v.getWord().length(), w.getWord().length())){
            if (v.getWord().length() > w.getWord().length()) {
                return 1;
            }
            if (v.getWord().length() < w.getWord().length()){
                return -1;
            }
            return 0;
        }else {
            if (v.getWord().charAt(index) > w.getWord().charAt(index)) {
                return 1;
            } else if (v.getWord().charAt(index) < w.getWord().charAt(index)) {
                return -1;
            } else {
                return TooSmall(v, w, index + 1);
            }
        }
    }
}
