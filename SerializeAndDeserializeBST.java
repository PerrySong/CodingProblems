import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    // inorder

    //      1
    //     / \
    //    2   3
    // 1 2 // 3 //
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                stack.push(cur.right);
                stack.push(cur.left);
                sb.append(cur.val);
                sb.append(',');
            } else {
                sb.append('*');
                sb.append(',');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        for (String node : nodes) {
            if (node.equals("*")) {
                queue.offer(null);
            } else {
                queue.offer(new TreeNode(Integer.parseInt(node)));
            }
        }

        return getTree(queue);

    }

    private TreeNode getTree(Queue<TreeNode> queue) {
        TreeNode cur = queue.poll();
        if (cur == null) return null;
        TreeNode left = getTree(queue);
        TreeNode right = getTree(queue);
        cur.left = left;
        cur.right = right;
        return cur;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBST a = new SerializeAndDeserializeBST();
        TreeNode b = new TreeNode(2);
        String cur = a.serialize(null);
        TreeNode c = a.deserialize(cur);
        System.out.println(c);
        System.out.println(cur);
    }
}
