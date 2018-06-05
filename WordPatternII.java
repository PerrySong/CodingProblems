import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {

    /**
     *

         Given a pattern and a string str, find if str follows the same pattern.

         Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

         Example 1:

         Input: pattern = "abab", str = "redblueredblue"
         Output: true
         Example 2:

         Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
         Output: true
         Example 3:

         Input: pattern = "aabb", str = "xyzabcxzyabc"
         Output: false
        Time: O(m ^ n)

     */

    public static boolean wordPatternMatch(String pattern, String str) {

        //Store pattern
        Map<Character, String> map = new HashMap<>();
        //Prevent duplicate
        Set<String> set = new HashSet<String>();
        return helper(str, 0, pattern, 0, map, set);
    }

    private static boolean helper(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
        if(i == str.length() && j == pattern.length()) return true;
        if(i == str.length() || j == pattern.length()) return false;
        if(map.containsKey(pattern.charAt(j))) {
            String p = map.get(pattern.charAt(j));
            if(!str.startsWith(p, i)) return false;
            return helper(str, i + p.length(), pattern, j + 1, map, set);
        }

        for(int k = i; k < str.length(); k++) {
            char c = pattern.charAt(j);

            String s = str.substring(i, k + 1);
            if(set.contains(s)) continue;
            map.put(c, s);
            set.add(s);

            if(helper(str, k + 1, pattern, j + 1, map, set))
                return true;

            map.remove(c);
            set.remove(s);
        }

        return false;
    }

    public static void main(String[] args) {
        wordPatternMatch("abab",
                "redblueredblue");
    }
}
