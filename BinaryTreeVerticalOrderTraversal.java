import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    /**
         Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

         If two nodes are in the same row and column, the order should be from left to right.

         Examples 1:

         Input: [3,9,20,null,null,15,7]

         3
         /\
         /  \
         9  20
         /\
         /  \
         15   7

         Output:

         [
         [9],
         [3,15],
         [20],
         [7]
         ]
         Examples 2:

         Input: [3,9,8,4,0,1,7]

         3
         /\
         /  \
         9   8
         /\  /\
         /  \/  \
         4  01   7

         Output:

         [
         [4],
         [9],
         [3,0,1],
         [8],
         [7]
         ]
         Examples 3:

         Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

         3
         /\
         /  \
         9   8
         /\  /\
         /  \/  \
         4  01   7
         /\
         /  \
         5   2

         Output:

         [
         [4],
         [9,5],
         [3,0,1],
         [8,2],
         [7]
         ]
     */

    /**Solution 1: T(n) = O(nlgn), Space: O(n)  lame solution */
//    class NodeIndex implements Comparable<NodeIndex> {
//        TreeNode node;
//        int index;
//        int level;
//        NodeIndex(TreeNode node, int index, int level) {
//            this.node = node;
//            this.index = index;
//            this.level = level;
//        }
//
//        public int compareTo(NodeIndex ni) {
//
//            return this.index - ni.index != 0 ? this.index - ni.index : this.level - ni.level;
//        }
//    }
//
//    public List<List<Integer>> verticalOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//
//        List<NodeIndex> niList = new ArrayList<>();
//        traverse(root, niList, 0, 0);
//        Collections.sort(niList);
//
//        for (int i = 0; i < niList.size(); i++) {
//            NodeIndex cur = niList.get(i);
//            List<Integer> numList = new ArrayList<>();
//            numList.add(cur.node.val);
//            while (i < niList.size() - 1 && cur.index == niList.get(i + 1).index) {
//                cur = niList.get(++i);
//                numList.add(cur.node.val);
//            }
//            res.add(numList);
//        }
//
//        return res;
//    }
//
//    private void traverse(TreeNode node, List<NodeIndex> list, int index, int level) {
//        if (node == null) return;
//        System.out.println(node.val);
//        list.add(new NodeIndex(node, index, level));
//        traverse(node.left, list, index - 1, level + 1);
//        traverse(node.right, list, index + 1, level + 1);
//    }

    /**
        Nice solution: Two queue, use a queue to record node's index
        T(n) = O(n)
        Space = O(n)
     */
    int max = 0;
    int min = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        range(root, 0);

        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }

        Queue<TreeNode> nQueue = new LinkedList<>();
        Queue<Integer> indexs = new LinkedList<>();

        nQueue.offer(root);
        indexs.offer(-min);//Root's index in res

        while (!nQueue.isEmpty()) {
            TreeNode cur = nQueue.poll();
            int idx = indexs.poll();
            res.get(idx).add(cur.val);
            if (cur.left != null) {
                nQueue.offer(cur.left);
                indexs.offer(idx - 1);
            }
            if (cur.right != null) {
                nQueue.offer(cur.right);
                indexs.offer(idx + 1);
            }
        }
        return res;
    }

    private void range(TreeNode node, int index) {
        if (node == null) return;
        max = Math.max(max, index);
        min = Math.min(min, index);
        range(node.left, index - 1);
        range(node.right, index + 1);
    }
}
