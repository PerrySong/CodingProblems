public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        serializeHelper(root, s);
        return new String(s);
    }

    public void serializeHelper(TreeNode root, StringBuilder s) {
        if(root == null) {
            s.append("/ ");
            return;
        }
        s.append(root.val + " ");
        serializeHelper(root.left, s);
        serializeHelper(root.right, s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");


        return deHelper(arr, new int[1]);
    }

    public TreeNode deHelper(String[] arr, int[] i) {
        if(i[0] > arr.length) return null;
        if(arr[i[0]].equals("/")) return null;
        System.out.println(arr[i[0]]);
        TreeNode node = new TreeNode(Integer.valueOf(arr[i[0]]));
        ++(i[0]);
        node.left = deHelper(arr, i);
        ++(i[0]);
        node.right = deHelper(arr, i);
        return node;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree b = new SerializeAndDeserializeBinaryTree();
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.right.left = new TreeNode(4);
        a.right.right = new TreeNode(5);
        System.out.println(b.serialize(a));



        b.deserialize(b.serialize(a)).printTreePreorder();
    }
}
