public class ContinusouSubarraySum {
    /**
         Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

         Example 1:
         Input: [23, 2, 4, 6, 7],  k=6
         Output: True
         Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
         Example 2:
         Input: [23, 2, 6, 4, 7],  k=6
         Output: True
         Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
         Note:
         The length of the array won't exceed 10,000.
         You may assume the sum of all the numbers is in the range of a signed 32-bit integer.

     */
    //nums : 1 2
    //sums : 0 1 1
    // k = 0
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        int[] sums = new int[nums.length + 1]; // Notice : we need a space for empty array, so that we can get the sum of [0 ~ n]
        int prev = 0;
        //Put sums into set
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] += prev + nums[i];
            prev = sums[i + 1];
        }

        for (int i = 1; i < sums.length; i++) {
            for (int j = 0; j < i - 1; j++) { // Notice : the shortest array len should be at least 2.
                if (k == 0 && sums[i] - sums[j] == 0 || k != 0 && (sums[i] - sums[j]) % k == 0) return true;
            }
        }
        return false;
    }
}
