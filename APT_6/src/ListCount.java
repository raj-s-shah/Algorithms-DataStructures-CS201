
public class ListCount {
    public int count (ListNode list) {
        int count = 0;
        while (list != null) {
            count += 1;
            list = list.next;
        }
        return count;
    }
}

