import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 137, BinaryTreeLevelOrderTraversal
 */

public class BinaryTreeLevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, res, 1);
        return res;
    }

    public static void helper(TreeNode node, List<List<Integer>> res, int level) {
        if(node == null) return;
        if(res.size() < level)
            res.add(new ArrayList<Integer>());
        System.out.println("Level is: " + level);
        System.out.println("size is: " + res.size());


        res.get(level - 1).add(node.val);
        helper(node.left, res, level + 1);
        helper(node.right, res, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(10);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(13);
        List<List<Integer>> res = levelOrder(root);
        for(List<Integer> list: res) {
            System.out.println(list);
        }
    }
}
