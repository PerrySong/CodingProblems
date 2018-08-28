public class LowestCommonAncestorOfBinaryTree {
    /**
         Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

         According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

         Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

         _______3______
         /              \
         ___5__          ___1__
         /      \        /      \
         6      _2       0       8
         /  \
         7   4
         Example 1:

         Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
         Output: 3
         Explanation: The LCA of of nodes 5 and 1 is 3.
         Example 2:

         Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
         Output: 5
         Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
         according to the LCA definition.
         Note:

         All of the nodes' values will be unique.
         p and q are different and both values will exist in the binary tree.
     */

    //T(n) = O(h^2)
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null) return null;
//         if (root == p || root == q) return root;
//         if (containsChild(root.right, p) && containsChild(root.right, q))
//             return lowestCommonAncestor(root.right, p, q);
//         else if (containsChild(root.left, p) && containsChild(root.left, q))
//             return lowestCommonAncestor(root.left, p, q);
//         else
//             return root;

//     }

//     public boolean containsChild(TreeNode root, TreeNode child) {
//         if (root == null) return false;
//         if (root == child) return true;
//         return containsChild(root.right, child) || containsChild(root.left, child);
//     }

    //Divide and conquer:

    /**
     * T(n) = O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }
}
