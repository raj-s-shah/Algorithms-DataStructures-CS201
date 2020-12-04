
public class DoubleList {
    public ListNode bigify(ListNode list) {
        if (list == null) return null;
        else{
            ListNode ret = bigify(list.next);
            list.next = new ListNode(list.info, ret);
            return list;
        }
    }
}