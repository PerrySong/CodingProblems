public class LongestPalindromeLendingHome {
    /**
         Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

         Example 1:

         Input: "babad"
         Output: "bab"
         Note: "aba" is also a valid answer.
         Example 2:

         Input: "cbbd"
         Output: "bb"
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int[] res = new int[] {0, 0};
        int max = 1;
        for (int i = 0; i < s.length(); i++) {

            int[] subPal1 = helper(s, i, i);
            int len1 = subPal1[1] - subPal1[0] + 1;

            int[] subPal2 = helper(s, i, i + 1);
            int len2 = subPal2[1] - subPal2[0] + 1;
            if (len1 > len2) {
                if (len1 > max) {
                    res = subPal1;
                    max = len1;
                }
            } else {
                if (len2 > max) {
                    res = subPal2;
                    max = len2;
                }
            }

        }
        return s.substring(res[0], res[1] + 1);
    }

    private int[] helper(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        int[] res = new int[2];
        res[0] = i + 1;
        res[1] = j - 1;
        return res;
    }
}
