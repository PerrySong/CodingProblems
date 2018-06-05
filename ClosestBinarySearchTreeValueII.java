import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {
    /**
         Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

         Note:

         Given target value is a floating point.
         You may assume k is always valid, that is: k ≤ total nodes.
         You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
         Example:

         Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

         4
         / \
         2   5
         / \
         1   3

         Output: [4,3]
         Follow up:
         Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
     */

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> predeccessors = new Stack<>();
        Stack<Integer> successors = new Stack<>();

        inorder(root, predeccessors, false, target);
        inorder(root, successors, true, target);
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            if(predeccessors.isEmpty()) {
                res.add(successors.pop());
            } else if(successors.isEmpty()) {
                res.add(predeccessors.pop());
            } else if(target - predeccessors.peek() < successors.peek() - target) {
                res.add(predeccessors.pop());
            } else {
                res.add(successors.pop());
            }
        }

        return res;
    }

    private void inorder(TreeNode root, Stack<Integer> stack, boolean reverse, double target) {
        if(root == null) return;

        inorder(reverse ? root.right : root.left, stack, reverse, target);
        if(reverse && root.val <= target || !reverse && root.val > target) return;
        stack.push(root.val);
        inorder(reverse? root.left : root.right, stack, reverse, target);
    }

    public static void main(String[] args) {
        ClosestBinarySearchTreeValueII a = new ClosestBinarySearchTreeValueII();
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(a.closestKValues(root, 3.714286, 2));
    }
}
