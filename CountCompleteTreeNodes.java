public class CountCompleteTreeNodes {
    /**
     *
         Given a complete binary tree, count the number of nodes.

         Note:

         Definition of a complete binary tree from Wikipedia:
         In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

         Example:

         Input:
         1
         / \
         2   3
         / \  /
         4  5 6

         Output: 6
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int level = 0;

        TreeNode cur = root;
        while (cur != null) {
            level++;
            cur = cur.left;
        }

        int totalNodesBeforeLastLevel = (1 << (level - 1)) - 1;
        return totalNodesBeforeLastLevel + nodesOfLastLevel(root, level);
    }

    public int nodesOfLastLevel(TreeNode root, int level) {
        if (root == null) return 0;
        if (level == 1 && root != null) return 1;
        if (level == 2) {
            if (root.right != null) return 2;
            if (root.left != null) return 1;
            return 0;
        }
        TreeNode midNode = root.left;

        for (int i = 0; i < level - 2; i++) {
            midNode = midNode.right;
        }

        if (midNode == null) return nodesOfLastLevel(root.left, level - 1);
        return (1 << (level - 2)) + nodesOfLastLevel(root.right, level - 1);

    }

    public static void main(String[] args) {
        CountCompleteTreeNodes a = new CountCompleteTreeNodes();
        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);
        b.left.left = new TreeNode(4);
        b.left.right = new TreeNode(5);
        b.right.left = new TreeNode(6);

        System.out.println(a.countNodes(b));
    }
}
