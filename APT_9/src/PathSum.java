public class PathSum {
    public int hasPath(int target, TreeNode tree){
        if (target == 0 && tree == null) {
            return 1;
        }
        else if(tree == null){
           return 0;
       }
        else {
            if (hasPath(target - tree.info, tree.left) + hasPath(target - tree.info, tree.right) > 0){
                return 1;
            }
            return 0;
        }

    }
}