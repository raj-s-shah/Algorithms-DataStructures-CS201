
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class AlphaLength {
    public ListNode create(String[] words) {
        TreeSet<String> temp = new TreeSet<>(Arrays.asList(words));
        ArrayList<String> wordsSorted = new ArrayList<>();
        wordsSorted.addAll(temp);

        ListNode first = createListNode(wordsSorted, 0);
//        while (last != null) {
//            for (int k = 1; k < wordsSorted.size(); k++){
//                last.next = new ListNode(wordsSorted.get(k).length(), null);
//                last = last.next;
//                }
//            last = null;
//            }
        return first;
    }

    public ListNode createListNode(ArrayList<String> words, int index) {
        if (index == words.size()) {
            return null;
        } else {
            ListNode afterMe = createListNode(words, index + 1);
            ListNode ret = new ListNode(words.get(index).length(), afterMe);
            return ret;

        }
    }
}

