public class LongestPalindromicSubstring {
    /**
         Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

         Example 1:

         Input: "babad"
         Output: "bab"
         Note: "aba" is also a valid answer.
         Example 2:

         Input: "cbbd"
         Output: "bb"

        Time:O(n)
        Space:O(1)
     */

    public String longestPalindrome(String s) {
        if(s == null) return null;
        String res = "";
        int len = s.length();
        for(int i = 0; i < len; i++){
            String cur1 = expand(s, i, i);
            String cur2 = expand(s, i, i + 1);
            String curMax = cur1.length() > cur2.length() ? cur1 : cur2;
            res = curMax.length() > res.length() ? curMax : res;
        }
        return res;
    }

    public String expand(String s, int i, int j) {
        int len = s.length();
        while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring a = new LongestPalindromicSubstring();
        a.longestPalindrome("a");
    }
}
