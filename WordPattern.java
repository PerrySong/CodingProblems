import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    /**
         Given a pattern and a string str, find if str follows the same pattern.

         Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

         Example 1:

         Input: pattern = "abba", str = "dog cat cat dog"
         Output: true
         Example 2:

         Input:pattern = "abba", str = "dog cat cat fish"
         Output: false
         Example 3:

         Input: pattern = "aaaa", str = "dog cat cat dog"
         Output: false
         Example 4:

         Input: pattern = "abba", str = "dog dog dog dog"
         Output: false
         Notes:
         You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
     */
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        char[] pArray = pattern.toCharArray();
        String[] sArray = str.split(" ");
        if(sArray.length != pArray.length) return false;
        for(int i = 0; i < pArray.length; i++) {
            if(map.containsKey(pArray[i]) && !map.get(pArray[i]).equals(sArray[i]))
                return false;
            if(!map.containsKey(pArray[i]) && map.containsValue(sArray[i]))
                return false;
            if(!map.containsKey(pArray[i]) && !map.containsValue(sArray[i]))
                map.put(pArray[i], sArray[i]);
        }
        return true;
    }
}
