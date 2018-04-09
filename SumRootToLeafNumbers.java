public class SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0);
    }

    public static int helper(TreeNode node, int tmp) {
        if(node == null) return 0;
        tmp = tmp*10 + node.val;
        if(node.left == null && node.right == null) return tmp;
        return helper(node.left, tmp) + helper(node.right, tmp);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(0);
        a.left = b;
        System.out.println("Yo" + sumNumbers(a));
    }
}
