import java.util.Arrays;

public class RegularExpressionMatching {
    /**
         Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

         '.' Matches any single character.
         '*' Matches zero or more of the preceding element.
         The matching should cover the entire input string (not partial).

         Note:

         s could be empty and contains only lowercase letters a-z.
         p could be empty and contains only lowercase letters a-z, and characters like . or *.
         Example 1:

         Input:
         s = "aa"
         p = "a"
         Output: false
         Explanation: "a" does not match the entire string "aa".
         Example 2:

         Input:
         s = "aa"
         p = "a*"
         Output: true
         Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
         Example 3:

         Input:
         s = "ab"
         p = ".*"
         Output: true
         Explanation: ".*" means "zero or more (*) of any character (.)".
         Example 4:

         Input:
         s = "aab"
         p = "c*a*b"
         Output: true
         Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
         Example 5:

         Input:
         s = "mississippi"
         p = "mis*is*p*."
         Output: false
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null || p.length() == 0 && s.length() != 0) return false;


        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        //initailize dp
        char[] sCharArr = s.toCharArray();
        char[] pCharArr = p.toCharArray();

        dp[0][0] = true;


        //Fill the first column **
        for (int row = 1; row < dp.length; row++) {
            if (pCharArr[row - 1] == '*')
                dp[row][0] = row == 1 || dp[row - 2][0];
        }

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {

//                System.out.println(row + " " + col);
                if (pCharArr[row - 1] == '*') {
                    if (row >= 2 && pCharArr[row - 2] == '.') {
                        dp[row][col] = col == 0 || dp[row - 1][col - 1] || dp[row - 1][col] || dp[row][col - 1];
                        System.out.println(row + " " + col);
                    } else { //If previous char matched extend or skip to p's next char
//                        System.out.println(sCharArr[col - 2] == sCharArr[col - 1]);

                        dp[row][col] = (col >= 2 && sCharArr[col - 2] == sCharArr[col - 1] || dp[row - 1][col]) || (row >= 2) && dp[row - 2][col] || dp[row - 1][col];

                    }
                } else if (pCharArr[row - 1] == '.') {
                    dp[row][col] = dp[row - 1][col - 1];
                } else if (pCharArr[row - 1] == sCharArr[col - 1]) {

                    dp[row][col] = dp[row - 1][col - 1];
                    System.out.println(row + " " + col);

                } else {
                    // dp[row][col] = false by default
//                    continue;
                }
                System.out.println(row + " " + col + ": " +  dp[row][col]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "ab*a*c*a"));
        System.out.println(isMatch("aaa", "ab*aa"));
    }
}
