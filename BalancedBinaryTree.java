public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return Math.abs(level(root.left) - level(root.right)) < 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int level(TreeNode node) {
        if(node == null) return 0;
        return Math.max(level(node.left), level(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        System.out.println(isBalanced(node1));
    }
}
