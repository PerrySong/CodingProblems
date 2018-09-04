public class PathSumIII {
    /**
         You are given a binary tree in which each node contains an integer value.

         Find the number of paths that sum to a given value.

         The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

         The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

         Example:

         root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

         10
         /  \
         5   -3
         / \    \
         3   2   11
         / \   \
         3  -2   1

         Return 3. The paths that sum to 8 are:

         1.  5 -> 3
         2.  5 -> 2 -> 1
         3. -3 -> 11
     */

    /**
     * T(n) = O(n ^ 2)
     * Space = O(n ^ 2)
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    private int helper(TreeNode node, int rest) {
        if (node == null) return 0;
        return (node.val == rest ? 1 : 0)
                + helper(node.left, rest - node.val) + helper(node.right, rest - node.val);
    }

//     public int pathSum(TreeNode root, int sum) {
//         if (root == null) return 0;
//         return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//     }

//     private int pathSumFrom(TreeNode node, int sum) {
//         if (node == null) return 0;
//         return (node.val == sum ? 1 : 0)
//             + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
//     }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.right = b;
        b.right = c;
        c.right = d;
        d.right = e;
        PathSumIII p = new PathSumIII();
        System.out.println(p.pathSum(a, 3));
    }
}
