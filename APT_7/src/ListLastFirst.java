import java.util.List;

public class ListLastFirst {
    public ListNode move(ListNode list) {
        ListNode first = list;
        if (list == null || list.next == null) {
            return list;
        }
        while (list.next.next != null) {
            list = list.next;
        }
        ListNode ret = list.next;
        list.next.next = first;
        list.next = null;

        return ret;
    }
}