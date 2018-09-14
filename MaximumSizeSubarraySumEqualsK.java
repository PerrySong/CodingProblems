import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    /**
         Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

         Note:
         The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

         Example 1:

         Input: nums = [1, -1, 5, -2, 3], k = 3
         Output: 4
         Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
         Example 2:

         Input: nums = [-2, -1, 2, 1], k = 1
         Output: 2
         Explanation: The subarray [-1, 2] sums to 1 and is the longest.
         Follow Up:
         Can you do it in O(n) time?
     */
    //T(n) = O(n ^ 2)
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null) return 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>(); // Store <sum[0, i], i>, only store the smallest i
        sumToIndex.put(0, -1);
        int sum = 0, res = 0; // sumj - sumi =  k


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum - k))
                res = Math.max(i - sumToIndex.get(sum - k), res);
            else if (!sumToIndex.containsKey(sum))
                sumToIndex.put(sum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSizeSubarraySumEqualsK a = new MaximumSizeSubarraySumEqualsK();
        System.out.println(a.maxSubArrayLen(new int[] {1, 1, 0}, 1));
    }
}
