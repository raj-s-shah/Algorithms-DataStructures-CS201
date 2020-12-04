
public class TreeBuilder {
    int[] myValues;

    public TreeNode recursion (int index) {
        if (index > myValues.length - 1) return null;
        TreeNode tree = new TreeNode(myValues[index], null, null);
        tree.left = recursion(2*index + 1);
        tree.right = recursion(2 * index + 2);
        return tree;
    }

    public TreeNode create(int[] values) {
        myValues = values;
        return recursion(0);
    }
}