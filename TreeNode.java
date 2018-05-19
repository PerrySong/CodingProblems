public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    public void printTreePreorder() {
          printTreePreorder(this);
    }

      public void printTreePreorder(TreeNode node) {
          if(node == null) {
              System.out.print("/ ");
              return;
          }
          System.out.print(node.val + " ");
          printTreePreorder(node.left);
          printTreePreorder(node.right);
      }
 }
