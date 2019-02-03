import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
     Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

     Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

     The encoded string should be as compact as possible.

     Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
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
        if (data == null) return null;
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
