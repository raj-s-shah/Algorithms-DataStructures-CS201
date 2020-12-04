public class HeightLabel {
    public TreeNode rewire(TreeNode t) {
        if (t == null) {
            return null;
        } else {
           return new TreeNode(findHeight(t), rewire(t.left), rewire(t.right));
        }
    }
    public int findHeight(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            return 1 + Math.max(findHeight(t.left), findHeight(t.right));
        }
    }
}