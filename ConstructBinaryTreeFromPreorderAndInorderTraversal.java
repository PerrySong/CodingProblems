public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, preorder.length, 0, inorder.length, preorder, inorder);
    }

    private TreeNode build(int preSt, int preEnd, int inSt, int inEnd, int[] preorder, int[] inorder) {
        if(preSt >= preEnd || preSt >= preorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preSt]);
        //Scan the inorder array to find the root index
        int i;
        for(i = inSt; i < inEnd; i++) {
            if(inorder[i] == preorder[preSt]) break;
        }
        //Build left subtree
        //Left subtree preSt = preSt + 1, preEnd = preSt + length of the left subtree, inSt = inSt, inEnd = i;
        node.left = build(preSt + 1, preSt + i - inSt + 1, inSt, i, preorder, inorder);
        //Build right subtree
        //Right subtree preSt = preSt + length of the left subtree,
        //preEnd = preSt + length of the subtree,
        //inSt = i, inEnd = inEnd;
        node.right = build(preSt + i - inSt + 1, preEnd, i + 1, inEnd, preorder, inorder);
        return node;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal a = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        a.buildTree(pre, in);

    }
}
