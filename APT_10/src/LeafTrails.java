
import java.net.Inet4Address;
import java.util.TreeMap;

public class LeafTrails {
    TreeMap<Integer, String> myMap;

    public String[] trails(TreeNode tree) {
        myMap = new TreeMap<>();
        doWork(tree, "");
        String[] ret = new String[myMap.keySet().size()];

        int index = 0;
        for (Integer s : myMap.keySet()) {
            ret[index] = myMap.get(s);
            index++;
        }
        return ret;
    }

    public void doWork(TreeNode tree, String path) {
        if (tree == null) return;
        if (tree.left == null && tree.right == null) {
            myMap.putIfAbsent(tree.info, path);
        }
        else{
            doWork(tree.left, path + "0" );
            doWork(tree.right, path + "1");
        }
    }

}
