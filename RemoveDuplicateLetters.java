public class RemoveDuplicateLetters {
    /**
     *
         Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

         Example 1:

         Input: "bcabc"
         Output: "abc"
         Example 2:

         Input: "cbacdcbc"
         Output: "acdb"

     * @param s
     * @return
     *
     */
    
    public String removeDuplicateLetters(String s) {
        if (s == null || s.equals("")) return s;
        int pos = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--count[s.charAt(i) - 'a'] == 0) break;
        }
        return pos == s.length() - 1 ? s.charAt(pos) + "" :  s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll(s.charAt(pos) + "", ""));
    }
}
