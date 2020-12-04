public class FilterTreeCount {
    public int count(TreeNode tree, int low, int high) {
        if (tree == null) {
            return 0;
        } else {
            if (tree.info >= low && tree.info <= high) {
                return 1 + count(tree.left, low, high) + count(tree.right, low, high);
            } else {
                return count(tree.left, low, high) + count(tree.right, low, high);
            }
        }
    }
}