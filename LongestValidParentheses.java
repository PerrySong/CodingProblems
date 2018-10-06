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
    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        int start = 0, end = 0, open = 0, res = 0;
        while(end < s.length()) {
            if (s.charAt(end) == '(')
                open++;
            else if (s.charAt(end) == ')') {
                open--;
            }
            if (open == 0) {
                res = Math.max(end - start + 1, res);
            }
            end++;
            if (open < 0) {
                start = end;
                open = 0;
            }

        }
        end--;

        while (open > 0 && start < s.length()) {
            if (s.charAt(start) == '(')
                open--;
            else if (s.charAt(start) == ')') {
                open++;
            }
            start++;
        }
        res = Math.max(end - start + 1, res);

        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses a = new LongestValidParentheses();
        System.out.println(a.longestValidParentheses("()(()"));
    }
}
