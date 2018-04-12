import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FlattenBinaryTree {
    public static void flatten(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        stack.push(root);
        queue.offer(root);
        TreeNode tmp = root;
        while(!stack.isEmpty()) {

            if(tmp != null && tmp.left != null) {
                tmp = tmp.left;
                stack.push(tmp);
                queue.offer(tmp);
            } else if(tmp != null && tmp.right != null){
                tmp = tmp.right;
                stack.push(tmp);
                queue.offer(tmp);
            } else {
                tmp = stack.pop().right;
            }
        }


        TreeNode prev = queue.poll();
        tmp = queue.poll();
        while(!queue.isEmpty()) {
            prev.right = tmp;
            prev.left = null;
            prev = tmp;
            tmp = queue.poll();

        }
        prev.left = null;
        prev.right = tmp;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.right = f;
        flatten(a);
        while(a != null) {
            System.out.println(a.val);
            a = a.right;
        }
    }
}
