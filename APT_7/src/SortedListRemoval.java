public class SortedListRemoval {
    public ListNode uniqify(ListNode list) {
        if (list == null) {
            return null;
        } else {
            list.next = uniqify(list.next);

            if (list.next != null &&
            list.next.info == list.info){
                return list.next;
            }
            return list;
        }
    }
}
