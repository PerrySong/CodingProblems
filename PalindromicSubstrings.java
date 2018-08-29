public class PalindromicSubstrings {
    /**
         Given a string, your task is to count how many palindromic substrings in this string.

         The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

         Example 1:
         Input: "abc"
         Output: 3
         Explanation: Three palindromic strings: "a", "b", "c".
         Example 2:
         Input: "aaa"
         Output: 6
         Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] cArray = s.toCharArray();
        int res = 0;
        for (int i = 0; i < cArray.length; i++) {
            res += extendPalindromic(cArray, i, i);
            res += extendPalindromic(cArray, i, i + 1);
        }
        return res;
    }

    private int extendPalindromic(char[] cArray, int i, int j) {
        int res = 0;
        while (i >= 0 && j < cArray.length && cArray[i] == cArray[j]) {
            res++;
            i--;
            j++;
        }
        return res;
    }
}
