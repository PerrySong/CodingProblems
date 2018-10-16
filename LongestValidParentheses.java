public class LongestValidParentheses {
    /**
         Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

         Example 1:

         Input: "(()"
         Output: 2
         Explanation: The longest valid parentheses substring is "()"
         Example 2:

         Input: ")()())"
         Output: 4
         Explanation: The longest valid parentheses substring is "()()"
     */

    /**
     * T(n) = n ^ 2
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 1) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            res = Math.max(res, findMaxParen(s, i)); // We assume i and j is the center, and extend from center
        return res;
    }
    private int findMaxParen(String s, int start) {
        int open = 0;
        int res = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else open--;
            if (open == 0) res = i - start + 1;
            if (open < 0) break;
        }
        return res;
    }

    /**
     * dp, T(n) = O(n), space = O (n)
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
//        if (s == null)
        return 1;
    }

    public static void main(String[] args) {
        LongestValidParentheses a = new LongestValidParentheses();
        System.out.println(a.longestValidParentheses("()(()"));
    }
}
