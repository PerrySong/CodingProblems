import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CountUniValueSubtree {

    /**
     *
         Given a binary tree, count the number of uni-value subtrees.

         A Uni-value subtree means all nodes of the subtree have the same value.

         Example :

         Input:  root = [5,1,5,5,5,null,5]

               5
              / \
             1   5
            / \   \
           5   5   5

         Output: 4
     */

    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[]{0};
        Map<TreeNode, Boolean> map = new HashMap<>();
        isUnival(root, map, res);

        return res[0];
    }

    public boolean isUnival(TreeNode root, Map<TreeNode, Boolean> map, int[] res) {
        if(root == null) return true;
        if(map.get(root) != null) return map.get(root);
        boolean left = isUnival(root.left, map, res);
        boolean right = isUnival(root.right, map, res);

        if(left && right) {
            if(root.left != null && root.left.val != root.val) {
                map.put(root, false);
                return false;
            } if(root.right != null && root.right.val != root.val) {
                map.put(root, false);
                return false;
            } else {
                res[0]++;
                map.put(root, true);
                return true;
            }

        }
        return false;
    }
}
