import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    /**
         Given a binary tree
         struct TreeLinkNode {
         TreeLinkNode *left;
         TreeLinkNode *right;
         TreeLinkNode *next;
         }
         Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

         Initially, all next pointers are set to NULL.

         Note:

         You may only use constant extra space.
         Recursive approach is fine, implicit stack space does not count as extra space for this problem.
         Example:

         Given the following binary tree,

                 1
                /  \
               2    3
              / \    \
            4   5    7
         After calling your function, the tree should look like:

                1 -> NULL
              /  \
             2 -> 3 -> NULL
            / \    \
          4-> 5 -> 7 -> NULL
         */

    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeLinkNode head = queue.poll();
            TreeLinkNode cur = head;
            while(!queue.isEmpty()) {
                cur.next = queue.poll();
                cur = cur.next;
            }
            cur = head;
            while(cur != null) {
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII a = new PopulatingNextRightPointersInEachNodeII();
        TreeLinkNode b = new TreeLinkNode(0);
        a.connect(b);
    }
}
