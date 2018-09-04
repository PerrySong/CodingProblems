public class BinaryTreeMaximumPathSum {
    /**
         Given a non-empty binary tree, find the maximum path sum.

         For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

         Example 1:

         Input: [1,2,3]

         1
         / \
         2   3

         Output: 6
         Example 2:

         Input: [-10,9,20,null,null,15,7]

         -10
         / \
         9  20
         /  \
         15   7

         Output: 42
     */

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;
        int lMax = helper(node.left);
        int rMax = helper(node.right);
        int myMax = Math.max(node.val, Math.max(node.val + rMax, Math.max(node.val + lMax, node.val + lMax + rMax)));
        max = Math.max(max, myMax);
        return Math.max(node.val, Math.max(node.val + rMax, node.val + lMax));
    }
}
