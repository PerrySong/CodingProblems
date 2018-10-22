public class FlipStringToMonotoneIncreasing {
    /**
     *
     User Accepted: 122
     User Tried: 184
     Total Accepted: 122
     Total Submissions: 221
     Difficulty: Medium
     A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)

     We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.

     Return the minimum number of flips to make S monotone increasing.



     Example 1:

     Input: "00110"
     Output: 1
     Explanation: We flip the last digit to get 00111.
     Example 2:

     Input: "010110"
     Output: 2
     Explanation: We flip to get 011111, or alternatively 000111.
     Example 3:

     Input: "00011000"
     Output: 2
     Explanation: We flip to get 00000000.


     Note:

     1 <= S.length <= 20000
     S only consists of '0' and '1' characters.
     */

    /**
     * Time limit exceed
     * @param S
     * @return
     */
//    public int minFlipsMonoIncr(String S) {
//        if (S == null) return 0;
//        int res = S.length();
//        for (int i = 0; i <= S.length(); i++) {
//            res = Math.min(res, (minChar(S, 0, i, 1) + minChar(S, i, S.length(), 0)));
//        }
//        return res;
//    }
//
//    private int minChar(String s, int start, int end, int num) {
//        int ones = 0, zeros = 0;
//        for (int i = start; i < end; i++) {
//            if (s.charAt(i) == '1') ones++;
//            else zeros++;
//        }
//        if (num == 0) return zeros;
//        return ones;
//    }

    public int minFlipsMonoIncr(String S) {
        if (S == null) return 0;
        int len = S.length();
        int res = len;

        int[] leftOnes = new int[len + 1], rightZeros = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '1') leftOnes[i + 1] = leftOnes[i] + 1;
            else leftOnes[i + 1] = leftOnes[i];
        }
        for (int i = len; i > 0; i--) {
            if (S.charAt(i - 1) == '0') rightZeros[i - 1] = rightZeros[i] + 1;
            else rightZeros[i - 1] = rightZeros[i];
        }
        for (int i = 0; i <= len; i++) {
            res = Math.min(leftOnes[i] + rightZeros[i], res);
        }

        return res;
    }


    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing a = new FlipStringToMonotoneIncreasing();
        System.out.println(a.minFlipsMonoIncr("00011000"));
    }
}
