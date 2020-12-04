import java.util.ArrayList;
import java.util.Arrays;

public class PairDown {
    public int[] fold(int[] list) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int k = 0; k < list.length; k+=2) {
            if(k == (list.length - 1)) {
                temp.add(list[k]);
            }
            else {
                temp.add(list[k] + list[k+1]);
            }
        }
        int[] ret = new int[temp.size()];
        for (int k = 0; k < ret.length; k++){
            ret[k] = temp.get(k);
        }
        return ret;
    }
}