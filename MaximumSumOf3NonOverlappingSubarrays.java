public class MaximumSumOf3NonOverlappingSubarrays {
    /**
         In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

         Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

         Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

         Example:
         Input: [1,2,1,2,6,7,5,1], 2
         Output: [0, 3, 5]
         Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
         We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
         Note:
         nums.length will be between 1 and 20000.
         nums[i] will be between 1 and 65535.
         k will be between 1 and floor(nums.length / 3).
     */

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        if (nums == null || nums.length == 0) return res;

        int[] sums = new int[nums.length - k + 1]; // store subarrays' sums, e.g. sums[0] store num[0 ~ k - 1] sum
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < sums.length - 1; i++) {
            sums[i] = sum;
            sum -= nums[i];
            sum += nums[i + k];
        }
        sums[sums.length - 1] = sum;

        int max = Integer.MIN_VALUE;
        for (int index1 = 0; index1 < sums.length; index1++) {
            for (int index2 = index1 + k; index2 < sums.length; index2++) {
                for (int index3 = index2 + k; index3 < sums.length; index3++) {
                    int threeSubSum = sums[index1] + sums[index2] + sums[index3];
                    if (max < threeSubSum) {
                        max = threeSubSum;
                        res = new int[] {index1, index2, index3};
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSumOf3NonOverlappingSubarrays a = new MaximumSumOf3NonOverlappingSubarrays();
        a.maxSumOfThreeSubarrays(new int[] {7,13,20,19,19,2,10,1,1,19},3);

    }
}
