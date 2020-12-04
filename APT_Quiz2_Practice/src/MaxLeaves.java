import java.util.*;

public class MaxLeaves {
    ArrayList<Integer> myLeafList;

    public int height(TreeNode tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

    public void leafCollectAndTrack(TreeNode tree, int height) {
        if (tree != null) {
            leafCollectAndTrack(tree.left, height - 1);
            if (tree.left == null && tree.right == null && height == 1) {
                myLeafList.add(tree.info);
            }
            leafCollectAndTrack(tree.right, height - 1);
        }
    }

    public int[] gather(TreeNode tree) {
        myLeafList = new ArrayList<>();

        int maxHeight = height(tree);
        leafCollectAndTrack(tree, maxHeight);

        int[] ret= new int[myLeafList.size()];
        for (int k = 0; k < myLeafList.size(); k++) {
            ret[k] = myLeafList.get(k);
        }

        return ret;
    }
}
