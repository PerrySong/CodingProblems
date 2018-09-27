public class OneEditDistance {
    /**
         Given two strings s and t, determine if they are both one edit distance apart.

         Note:

         There are 3 possiblities to satisify one edit distance apart:

         Insert a character into s to get t
         Delete a character from s to get t
         Replace a character of s to get t
         Example 1:

         Input: s = "ab", t = "acb"
         Output: true
         Explanation: We can insert 'c' into s to get t.
         Example 2:

         Input: s = "cab", t = "ad"
         Output: false
         Explanation: We cannot get t from s by only one step.
         Example 3:

         Input: s = "1203", t = "1213"
         Output: true
         Explanation: We can replace '0' with '1' to get t.
     */
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;
        int minLen = Math.min(s.length(), t.length());
        for (int i = 0; i < minLen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length())
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() > t.length())
                    return s.substring(i + 1).equals(t.substring(i));
                else
                    return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return !s.equals(t) && s.substring(0, minLen).equals(t.substring(0, minLen));
    }

    public static void main(String[] args) {
        OneEditDistance a = new OneEditDistance();
        System.out.println(a.isOneEditDistance("a", "A"));
    }
}
