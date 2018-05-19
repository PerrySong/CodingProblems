import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        findPath(res, new ArrayList<Integer>(), sum, root);
        return res;
    }

    private void findPath(List<List<Integer>> res, List<Integer> list, int sum, TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null) {
            if(listSum(list) == sum)
                res.add(new ArrayList(list));
            return;
        }

        findPath(res, list, sum, root.left);
        findPath(res, list, sum, root.right);

        list.remove(list.size() - 1);
    }

    private int listSum(List<Integer> list) {
        int res = 0;
        for(int i: list) {
            res += i;
        }
        return res;
    }
}
