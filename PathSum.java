public class PathSum {

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

     Note: A leaf is a node with no children.

     Example:

     Given the below binary tree and sum = 22,

             5
            / \
           4   8
          /   / \
         11  13  4
        /  \      \
       7    2      1
     return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

     AmazonDebug: Runtime: O(2^log n)
               Space: O(1)
     */

    boolean hasSameSum = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        helper(root, sum, 0);
        return hasSameSum;
    }

    private void helper(TreeNode root, int sum, int dist) {

        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(dist + root.val  == sum) hasSameSum = true;
            return;
        }
        if(!hasSameSum)
            helper(root.left, sum, dist + root.val);
        if(!hasSameSum)
            helper(root.right, sum, dist + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right  = new TreeNode(1);

        PathSum a = new PathSum();
        System.out.println(a.hasPathSum(root, 22));
    }
}
