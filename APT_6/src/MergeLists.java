import org.w3c.dom.NodeList;

import java.util.List;

public class MergeLists {
    public ListNode weave(ListNode a, ListNode b) {
        ListNode temp = new ListNode(a.info, null);
        a = a.next;
        ListNode first = temp;
        int counter = 1;
        while (b != null) {
            if (counter % 2 == 0) {
                temp.next = a;
                temp = temp.next;
                a = a.next;
            }
            if (counter % 2 != 0) {
                temp.next = b;
                temp = temp.next;
                b = b.next;
            }
            counter++;
        }
        return first;
    }
}