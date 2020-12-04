
import java.util.ArrayList;
import java.util.Collections;

public class TreeSort {
     public ArrayList<Integer> mySet = new ArrayList<>();

    public void addNodes(TreeNode tree) {
        if (tree != null) {

            mySet.add(tree.info);
            addNodes(tree.left);
            addNodes(tree.right);
        }

    }

    public int[] sort(TreeNode tree) {
        addNodes(tree);

        int[] ret = new int[mySet.size()];

        Collections.sort(mySet);
        for (int k = 0; k < mySet.size(); k++) {
            ret[k] = mySet.get(k);
        }

        return ret;
    }
}