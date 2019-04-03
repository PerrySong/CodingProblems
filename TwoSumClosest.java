import java.util.Arrays;

public class TwoSumClosest {
    /**
         Description
         Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

         Return the difference between the sum of the two integers and the target.



         Example
         Given array nums = [-1, 2, 1, -4], and target = 4.

         The minimum difference is 1. (4 - (2 + 1) = 1).



         Challenge
         Do it in O(nlogn) time complexity.
     */

    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public static int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return target;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start < end) {
            res = Math.min(res, Math.abs(target - (nums[start] + nums[end])));
            if (nums[start] + nums[end] > target) end--;
            if (nums[start] + nums[end] < target) start++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a = new int[]{-1, 2, 1, -4};
        System.out.println(twoSumClosest(a, 4));
    }
}
