public class ValidateBinarySearchTree {
    /**
         Given a binary tree, determine if it is a valid binary search tree (BST).

         Assume a BST is defined as follows:

         The left subtree of a node contains only nodes with keys less than the node's key.
         The right subtree of a node contains only nodes with keys greater than the node's key.
         Both the left and right subtrees must also be binary search trees.
         Example 1:

         Input:
         2
         / \
         1   3
         Output: true
         Example 2:

         5
         / \
         1   4
         / \
         3   6
         Output: false
         Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
         is 5 but its right child's value is 4.
     */

    /**
     * Use Divide and conquer
     * T(n) = O(n)
     * Space = O(n)
     */
    class DataTypes {
        boolean isBST;
        int max;
        int min;
        DataTypes(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root).isBST;
    }

    private DataTypes helper(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return new DataTypes(true, node.val, node.val);
        }

        DataTypes left = helper(node.left);
        DataTypes right = helper(node.right);

        boolean isBST = (left == null ? true : left.isBST) &&
                (right == null ? true : right.isBST) &&
                (right == null || node.val < right.min) && (left == null || node.val > left.max);

        int min = left == null ? node.val : left.min;
        int max = right == null ? node.val : right.max;
        return new DataTypes(isBST, max, min);

    }

    /**
     * Beats 100%
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        return helper2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper2(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return helper2(node.left, min, node.val) && helper2(node.right, node.val, max);
    }
}
