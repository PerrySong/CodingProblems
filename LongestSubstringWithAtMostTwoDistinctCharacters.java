public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /**
     *
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
        if(s == null && s.length() == 0) return 0;
        int[] count = new int[256];
        int res = 0;
        int different = 0;
        int j = 0, i = 0;
        while(j < s.length() && i < s.length()) {
            if(different <= 2) {

                if(count[s.charAt(i)] == 0)
                    different++;
                count[s.charAt(i)]++;
                i++;
                if(different <= 2)
                    res = Math.max(i - j, res);
            } else {
                count[s.charAt(j)]--;
                if(count[s.charAt(j)] == 0)
                    different--;
                j++;
            }
        }
        return res;
    }
}
