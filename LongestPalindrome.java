public class LongestPalindrome {
    /**
         Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

         This is case sensitive, for example "Aa" is not considered a palindrome here.

         Note:
         Assume the length of given string will not exceed 1,010.

         Example:

         Input:
         "abccccdd"

         Output:
         7

         Explanation:
         One longest palindrome that can be built is "dccaccd", whose length is 7.
     */

    public int longestPalindrome(String s) {
        if (s == null) return 0;
        int size = s.length();
        int[] charCount = new int[128];
        int res = 0;

        for (int i = 0; i < size; i++) {
            char chr = s.charAt(i);
            charCount[chr]++;
            if (charCount[chr] % 2 == 0) res += 2;
        }

        if (res < size) return res + 1;
        return res;

    }
}
