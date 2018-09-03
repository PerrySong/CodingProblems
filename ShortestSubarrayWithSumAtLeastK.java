public class ShortestSubarrayWithSumAtLeastK {
    /**
         Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

         If there is no non-empty subarray with sum at least K, return -1.



         Example 1:

         Input: A = [1], K = 1
         Output: 1
         Example 2:

         Input: A = [1,2], K = 4
         Output: -1
         Example 3:

         Input: A = [2,-1,2], K = 3
         Output: 3


         Note:

         1 <= A.length <= 50000
         -10 ^ 5 <= A[i] <= 10 ^ 5
         1 <= K <= 10 ^ 9
     */

    // Brute force: length starts from 1 to length
    // loop over the array sum every sub array
    // T(n) = (1 + 2 + 3 + ... + n) * T(sum(n)) = O(n ^ 3)

    //dp: Store sub array information in a 2D matrix
    // dp[i][j]: sub array that starts from i ends to j
    // dp[i][j] = dp[i][j - 1] + A[j];
    // T(n) = O(n ^ 2)
    // Space = O(n ^ 2)


    // dp: Store sub array information in an array
    //
    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) return - 1;
        int[] sums = new int[A.length];

        //Initialize dp
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
            if (A[i] == K) {
                System.out.println("???");
                return 1;
            }
            sums[i] = A[i];
        }

        for (int len = 2; len <= A.length; len++) {
            for (int start = 0; start <= A.length - len; start++) {
                int sum = sums[start] + A[start + len - 1];
                if (sum >= K) return len;
                sums[start] = sum;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK a = new ShortestSubarrayWithSumAtLeastK();
        System.out.println(a.shortestSubarray(new int[] {77,19,35,10,-14}, 19));
    }
}
