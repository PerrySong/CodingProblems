public class PopulatingNextRightPointersInEachNode {
    /**
     * Definition for binary tree with next pointer.
     */
      public static class TreeLinkNode {
          int val;
          TreeLinkNode left, right, next;
          TreeLinkNode(int x) { val = x; }
      }


      public static void connect(TreeLinkNode root) {
          if(root == null) return;

          System.out.println("Hey: " + root.val);

          while(root != null) {
              TreeLinkNode temp = root;

              System.out.println(root.val);
              while(temp != null && temp.left != null) {
                  temp.left.next = temp.right;
                  if(temp.next != null) {
                      temp.right.next = temp.next.left;

                  }
                  temp = temp.next;
              }
              root = root.left;

          }
      }

    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        a.left = b;
        a.right = c;
        connect(a);
    }
}
