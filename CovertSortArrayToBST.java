public class CovertSortArrayToBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = helper(nums, 0, nums.length - 1);
        return res;
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if(low > high) {
            return null;
        }

        int mid = (high + low) / 2;

        TreeNode res = new TreeNode(nums[mid]);
        res.right = helper(nums, mid + 1, high);
        res.left = helper(nums, low, mid - 1);
        return res;
    }

    public static void main(String[] args) {
        
    }

}
