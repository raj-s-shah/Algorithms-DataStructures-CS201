public class ListSum {
    public int sum(ListNode list, int thresh) {
//        int sum = 0;
//        while (list != null){
//            if (list.info > thresh) {
//                sum += list.info;
//            }
//            list = list.next;
//        }
//        return sum;
         if (list == null) {
             return 0;
         }
         else {
             if (list.info <= thresh){
                 return sum(list.next, thresh);
             }
             return list.info + sum(list.next,thresh);
             }
         }
    }
