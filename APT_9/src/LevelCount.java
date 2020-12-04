public class LevelCount {
    public int count(TreeNode t, int level) {
        if (level == 0 && t != null) {
            return 1;
        }
        else if (t == null) {
            return 0;
        }
        else {
            return count(t.left, level - 1) + count(t.right, level - 1);
        }

    }
}