public class DecodeWays {
    /**
         A message containing letters from A-Z is being encoded to numbers using the following mapping:

         'A' -> 1
         'B' -> 2
         ...
         'Z' -> 26
         Given a non-empty string containing only digits, determine the total number of ways to decode it.

         Example 1:

         Input: "12"
         Output: 2
         Explanation: It could be decoded as "AB" (1 2) or "L" (12).
         Example 2:

         Input: "226"
         Output: 3
         Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     */


    //T(n) = O(n ^ 2)
//     public int numDecodings(String s) {
//         if (s == null) return 0;
//         res = 0;
//         dfs(s, 0, s.substring(0, 1));
//         return res;
//     }


//     public void dfs(String s, int start, String tmp) {

//         if (tmp.startsWith("0")) return;
//         if (Integer.valueOf(tmp) > 26 || Integer.valueOf(tmp) < 1) return;

//         if (start == s.length()) {
//             res++;
//             return;
//         }

//         if (start + 1 <= s.length())
//             dfs(s, start + 1, s.substring(start, start + 1));
//         if (start + 2 <= s.length())
//             dfs(s, start + 2, s.substring(start, start + 2));
//     }


    // int res = 0;
    //Time limited exceed

    // Questions: All int is positive?
    // Testcases: "00", "0", "1"

     public int numDecodings(String s) {

         if (s == null || s.length() == 0) return 0;
         if (s.startsWith("0")) return 0;
         int len = s.length();


         int[] dp = new int[len + 1];
         dp[0] = 1;
         dp[1] = 1;
         for (int i = 2; i < len + 1; i++) {
             int val1 = Integer.valueOf(s.substring(i - 1, i));
             int val2 = Integer.valueOf(s.substring(i - 2, i));
             if (val1 > 0 && val1 < 10) {
                 dp[i] += dp[i - 1];
             }
             if (s.charAt(i - 2) != '0' && val2 <= 26) {
                 dp[i] += dp[i - 2];
             }
         }
         return dp[len];
     }


    /**
     * Testcase: 110 decode -> 1 10,
     *
     * cur num1 num2
     *      1    1
     *  2
     *      1    2
     *
     *
     * @param s
     * @return
     */

    public int numDecodings2(String s) {

        if (s == null || s.length() == 0) return 0;
        if (s.startsWith("0")) return 0;
        int len = s.length();

        int num1 = 1;
        int num2 = 1;

        for (int i = 2; i < len + 1; i++) {
            int val1 = Integer.valueOf(s.substring(i - 1, i));
            int val2 = Integer.valueOf(s.substring(i - 2, i));
            int currentNum = 0;
            if (val1 > 0 && val1 < 10) {

                currentNum += num2;
            }
            if (s.charAt(i - 2) != '0' && val2 <= 26)
                currentNum += num1;

            num1 = num2;
            num2 = currentNum;
        }

        return num2;
    }

    public static void main(String[] args) {
        DecodeWays a = new DecodeWays();
        System.out.println(a.numDecodings2("110"));
    }


}
