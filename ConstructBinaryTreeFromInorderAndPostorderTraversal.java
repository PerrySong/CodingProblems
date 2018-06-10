public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /**
         Given inorder and postorder traversal of a tree, construct the binary tree.

         Note:
         You may assume that duplicates do not exist in the tree.

         For example, given

         inorder = [9,3,15,20,7]
         postorder = [9,15,7,20,3]
         Return the following binary tree:

           3
          / \
         9  20
           /  \
          15   7
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return root(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode root(int[] inorder, int[] postorder, int inS, int inE, int posS, int posE) {
        if(posE < posS || inE < inS) return null;

        int i;
        for(i = inS; i <= inE; i++) {
            if(inorder[i] == postorder[posE]) break;
        }

        TreeNode root = new TreeNode(inorder[i]);



        root.left = root(inorder, postorder, inS, i - 1, posS, posS + (i - 1 - inS));

        root.right = root(inorder, postorder, i + 1, inE, posS + (i - 1 - inS) + 1, posE - 1);

        return root;


    }
}
