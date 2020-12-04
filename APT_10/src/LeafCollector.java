import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.List;

public class LeafCollector {
    ArrayList<String>myList;

    public String[] getLeaves(TreeNode tree) {
        myList = new ArrayList<>();

        collectAndRemove(tree, myList);

        return myList.toArray(new String[0]);
    }

    public boolean isLeaf (TreeNode tree) {
        if (tree.left == null && tree.right == null) {
            return true;
        }
        return false;
    }

    public void collectAndRemove(TreeNode root, List<String> myList) {
        if (root != null) {
            collectAndRemove(root.left, myList);
            if (isLeaf(root.left)) {
                myList.add("" + root.left.info);
                root.left = null;
            }
            if (isLeaf(root.right)) {
                myList.add("" + root.right.info);
                root.right = null;
            }
            collectAndRemove(root.right, myList);
        }
    }
}