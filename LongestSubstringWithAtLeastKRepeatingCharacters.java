public class LongestSubstringWithAtLeastKRepeatingCharacters {
    /**
         Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

         Example 1:

         Input:
         s = "aaabb", k = 3

         Output:
         3

         The longest substring is "aaa", as 'a' is repeated 3 times.
         Example 2:

         Input:
         s = "ababbc", k = 2

         Output:
         5

         The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) return 0;
        int res = 0;
        char[] charArr = s.toCharArray();
        for (int unique = 1; unique <= 26; unique++) {
            int start = 0, end = 0, curUnique = 0, kTimesAtLeast = 0;
            int[] freq = new int[26];
            while (end < charArr.length) {
                if (curUnique <= unique) {
                    int idx = charArr[end] - 'a';
                    if (freq[idx] == 0)
                        curUnique++;
                    freq[idx]++;
                    if (freq[idx] == k)
                        kTimesAtLeast++;
                    end++;
                } else {
                    int idx = charArr[start] - 'a';
                    if (freq[idx] == k)
                        kTimesAtLeast--;
                    freq[idx]--;
                    if (freq[idx] == 0)
                        curUnique--;
                    start++;
                }
                if (curUnique == kTimesAtLeast) {
                    res = Math.max(res, end - start);
                }

            }
        }
        return res;
    }
//    private int longest;
//    public int longestSubstring(String s, int k) {
//        if (s == null || s.length() < k) return 0;
//        longest = 0;
//        int[] freq = new int[26];
//        int uniqueChar = 0;
//        int kTimesChar = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char curC = s.charAt(i);
//            if (freq[curC - 'a']++ == 0) uniqueChar++;
//            if (freq[curC - 'a'] == k) kTimesChar++;
//        }
//        System.out.println(uniqueChar + " : " + kTimesChar);
//        helper(s, k, freq, uniqueChar, kTimesChar, 0, s.length() - 1);
//        return longest;
//    }
//
//    private void helper(String s, int k, int[] freq, int uniqueChar, int kTimesChar, int start, int end) {
//        if (end - start + 1 <= longest) return;
//        if (uniqueChar == kTimesChar) {
//            System.out.println(" :" + uniqueChar + " : " + kTimesChar);
//            System.out.println(end + " : " + start);
//            longest = end - start + 1;
//        }
//        char charStart = s.charAt(start), charEnd = s.charAt(end);
//        // remove charStart
//        int ucStart = uniqueChar, ucEnd = uniqueChar, ktStart = kTimesChar, ktEnd = kTimesChar;
//
//        if (--freq[charStart - 'a'] == 0) {
//            ucStart--;
//        }
//        if (freq[charStart - 'a'] == k - 1) {
//            System.out.println("yo");
//            ktStart--;
//        }
//        helper(s, k, freq, ucStart, ktStart, start + 1, end);
//
//        freq[charStart - 'a']++; // maintain the freq
//
//        if (--freq[charEnd - 'a'] == 0) { // decrease the freq by 1
//            ucEnd--;
//        }
//        if (freq[charEnd - 'a'] == k - 1) {
//            System.out.println("yo");
//            ktEnd--;
//        }
//        helper(s, k, freq, ucEnd, ktEnd, start, end - 1);
//        freq[charEnd - 'a']++;
//    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters a = new LongestSubstringWithAtLeastKRepeatingCharacters();
//        a.longestSubstring("aaabb", 3);
        System.out.println(a.longestSubstring("bbaaacbd"
                ,3));
    }
}
