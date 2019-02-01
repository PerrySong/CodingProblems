import java.util.HashSet;
import java.util.Set;

public class ConsecutiveNumberSum {

    /**
         Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

         Example 1:

         Input: 5
         Output: 2
         Explanation: 5 = 5 = 2 + 3
         Example 2:

         Input: 9
         Output: 3
         Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
         Example 3:

         Input: 15
         Output: 4
         Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
         Note: 1 <= N <= 10 ^ 9.
     */

    // Memory limit eceed
    public static int consecutiveNumbersSum(int N) {
        if (N <= 0) return 0;
        int res = 0;
        long[] sums = new long[N + 1];
        Set<Long> sumSet = new HashSet<>();
        sumSet.add((long)0);
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + i;
            sumSet.add(sums[i]);
        }

        for (int i = 0; i < sums.length; i++) {
            if (sumSet.contains(sums[i] - N))
                res++;
        }
        return res;
    }




    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(855204));
    }
}
