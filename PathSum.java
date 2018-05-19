public class PathSum {

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
