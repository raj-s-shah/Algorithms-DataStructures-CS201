import java.util.ArrayList;

public class UniqueNodes {
    public int sum(ListNode list) {
        int sum = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        while (list != null){
            if (!nums.contains(list.info)){
                sum += list.info;
                nums.add(list.info);
            }
            list = list.next;
        }
        return sum;
    }
}
