public class MinimumSizeSubarraySum {
    /**
         Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

         Example:

         Input: s = 7, nums = [2,3,1,2,4,3]
         Output: 2
         Explanation: the subarray [4,3] has the minimal length under the problem constraint.
         Follow up:
         If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int res = nums.length;
        while(p2 < nums.length) {
            while(sum < s) {
                sum += nums[p2++];
            }
            while(sum >= s) {
                res = Math.min(res, p2 - p1);
                sum -= nums[p1++];
            }
        }
        if(sum + nums[p1 - 1] >= s) return res;
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        minSubArrayLen(7, arr);
    }
}
