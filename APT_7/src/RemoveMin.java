import java.util.ArrayList;
import java.util.PriorityQueue;

public class RemoveMin {
    public ListNode remove (ListNode list) {
        if (list == null || list.next == null){
            return null;
        }
        else {
            ArrayList<Integer> store = new ArrayList<>();
            while (list != null) {
                store.add(list.info);
                list = list.next;
            }
            int min = store.get(0);

            for (Integer num : store) {
                if (num < min) {
                    min = num;
                }
            }
            store.remove(store.indexOf(min));
            return create(store, 0);
        }
    }
    public ListNode create (ArrayList<Integer> store, int n) {
        if (n == store.size()){
            return null;
        } else {
            n++;
            ListNode afterMe = create(store, n);
            ListNode ret = new ListNode(store.get(n - 1), afterMe);
            return ret;
        }
    }
}