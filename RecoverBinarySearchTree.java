import java.util.Stack;

public class RecoverBinarySearchTree {
    /**
         Two elements of a binary search tree (BST) are swapped by mistake.

         Recover the tree without changing its structure.

         Example 1:

         Input: [1,3,null,null,2]

         1
         /
         3
         \
         2

         Output: [3,1,null,null,2]

         3
         /
         1
         \
         2
         Example 2:

         Input: [3,1,4,null,null,2]

         3
         / \
         1   4
         /
         2

         Output: [2,1,4,null,null,3]

         2
         / \
         1   4
         /
         3
         Follow up:

         A solution using O(n) space is pretty straight forward.
         Could you devise a constant space solution?
     */
    //BST : inorder is acesending
    //// T(n) = O(n)
    // Space = O(n)
    // Recursion solution
//     TreeNode first = null;
//     TreeNode second = null;
//     TreeNode prev = null;
//     public void recoverTree1(TreeNode root) {
//         if (root == null) return;
//         helper(root);
//         int tmp = first.val;
//         first.val = second.val;
//         second.val = tmp;
//     }

//     // Recursive solution:
//     public void helper(TreeNode root) {
//         if (root == null) return;
//         helper(root.left);
//         if (prev != null && root.val < prev.val) {
//             if (first == null)
//                 first = prev;
//             second = root;

//         }
//         prev = root;
//         helper(root.right);
//     }

    // Iteration solution
    // T(n) = O(n)
    // Space = O(n)
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;

            } else {
                cur = stack.pop();
                System.out.println(cur.val);
                if (prev != null && cur.val < prev.val) {
                    if (first == null) first = prev;
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
