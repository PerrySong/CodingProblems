import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    /**
     *
         Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

         Note: The input string may contain letters other than the parentheses ( and ).

         Example 1:

         Input: "()())()"
         Output: ["()()()", "(())()"]
         Example 2:

         Input: "(a)())()"
         Output: ["(a)()()", "(a())()"]
         Example 3:

         Input: ")("
         Output: [""]
     */
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        dfs(s, res, 0, l, r);
        return res;
    }


    private static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }

    private static void dfs(String s, List<String> list, int start, int l, int r) {
        if (isValid(s)) {
            list.add(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i != 0 && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(' && l > 0) {

                dfs(s.substring(0, i) + s.substring(i + 1), list, i, l - 1, r);
            } else if (s.charAt(i) == ')' && r > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), list, i, l, r - 1);
            }
        }
    }
    public static void main(String[] args) {
//        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses(")("));
    }
}
