public class PermutationInString {
    /**
         Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
         Example 1:
         Input:s1 = "ab" s2 = "eidbaooo"
         Output:True
         Explanation: s2 contains one permutation of s1 ("ba").
         Example 2:
         Input:s1= "ab" s2 = "eidboaoo"
         Output: False
         Note:
         The input strings only contain lower case letters.
         The length of both given strings is in range [1, 10,000].
     */

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        int s1Len = s1.length();
        int[] charCount = new int[26];
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }

        int match = 0;
        int i = 0, j = 0;
        while (j < s1Len) {
            char curC = s2.charAt(j++);
            if (charCount[curC - 'a']-- > 0) match++;
        }

        while (j < s2.length()) {
            if (match == s1Len) return true;
            if (charCount[s2.charAt(i++) - 'a']++ >= 0) match--;
            if (charCount[s2.charAt(j++) - 'a']-- > 0) match++;
        }
        return match == s1Len;
    }

    public static void main(String[] args) {
        PermutationInString a = new PermutationInString();
        System.out.println(a.checkInclusion("adc", "abdac"));
    }
}
