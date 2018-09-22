public class LongestSubstringWithoutRepeatingCharacters {
    /**
     *
         Given a string, find the length of the longest substring without repeating characters.

         Examples:

         Given "abcabcbb", the answer is "abc", which the length is 3.

         Given "bbbbb", the answer is "b", with the length of 1.

         Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
s

     */

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] count = new int[256];
        int start = 0, end = 0;
        int max = 0;
        while(end < s.length()) {

            while(start < s.length() && count[s.charAt(end)] == 1) {
                count[s.charAt(start++)]--;
            }
            count[s.charAt(end)]++;
            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }
}
