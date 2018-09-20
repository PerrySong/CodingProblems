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
        for (int row = 0; row < dp.length - 1; row++) {
            if (pCharArr[row] == '*')
                dp[row + 1][0] = row >= 1 && dp[row - 1][0];
        }

        for (int row = 0; row < dp.length - 1; row++) {
            for (int col = 0; col < dp[0].length - 1; col++) {
                if (pCharArr[row] == '.' || pCharArr[row] == sCharArr[col]) {
                    dp[row + 1][col + 1] = dp[row][col];
                } else if (pCharArr[row] == '*') {
                    if (row >= 1 && dp[row - 1][col + 1])
                        dp[row + 1][col + 1] = true; // Delete the previous char
                    else if (row >= 1 && pCharArr[row - 1] == '.') { // if previous char in p is '.' or previous s Char == current s char (* represent extend).
                        dp[row + 1][col + 1] = dp[row][col] || dp[row + 1][col];
                    } else if (dp[row][col + 1]) { // ignore *
                        dp[row + 1][col + 1] = true;
                    } else if (col >= 1 && sCharArr[col] == sCharArr[col - 1]) { // Extend *,
                        dp[row + 1][col + 1] = dp[row][col];
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {

        System.out.println(isMatch("aaa", ".*"));
        System.out.println(isMatch("aaa", "ab*a"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aaca", "ab*a*c*a"));
        System.out.println(isMatch("aaa", "ab*a*c*a"));
//        System.out.println(isMatch("aaa", "ab*a*c*a"));
//        System.out.println(isMatch("aaa", "ab*aa"));
    }
}
