import java.util.List;

public class ListStretch {
    public ListNode stretch (ListNode list, int amount) {
    if (list == null) {
        return null;
    } else {
        ListNode afterMe = stretch(list.next, amount);
        list.next = multiplier(amount - 1, list.info);
        ListNode temp = list;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = afterMe;
        return list;
    }
    }
    public ListNode multiplier (int n, int info){
        if (n == 0) {
            return null;
        } else {
            n--;
            ListNode next = multiplier(n, info);
            ListNode afterMe = new ListNode(info, next);
            return afterMe;
        }
    }

}