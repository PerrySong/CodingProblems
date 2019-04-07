public class LongestSubstringWithAtMostTwoDistinctTwoCharacters {
    /**
         Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

         Example 1:

         Input: "eceba"
         Output: 3
         Explanation: t is "ece" which its length is 3.
         Example 2:

         Input: "ccaabbb"
         Output: 5
         Explanation: t is "aabbb" which its length is 5.
     */

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0, distincts = 0, start = 0, end = 0;
        int[] counts = new int[128];

        while (end < s.length()) {

            char newChar = s.charAt(end);
            int index = newChar - '0';
            // 1. newChar is in the current subsrting
            // 2. newChar is not in the current substring
            if (counts[index] != 0) { // 1
                counts[index]++;
                end++;
            } else { // 2
                while (distincts > 1 && start < end) {
                    char startChar = s.charAt(start);
                    int startCharIndex = startChar - '0';
                    counts[startCharIndex]--;
                    if (counts[startCharIndex] == 0)
                        distincts--;
                    start++;
                }
                distincts++;
                counts[index]++;
                end++;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctTwoCharacters a = new LongestSubstringWithAtMostTwoDistinctTwoCharacters();
        System.out.println(a.lengthOfLongestSubstringTwoDistinct("aaacb"));
    }
}
