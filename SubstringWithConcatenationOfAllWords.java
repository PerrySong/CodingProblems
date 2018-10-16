import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    /**
     *
         You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

         Example 1:

         Input:
         s = "barfoothefoobarman",
         words = ["foo","bar"]
         Output: [0,9]
         Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
         The output order does not matter, returning [9,0] is fine too.
         Example 2:

         Input:
         s = "wordgoodstudentgoodword",
         words = ["word","student"]
         Output: []
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;
        int wordNum = words.length, wordLen = words[0].length();
        Map<String, Integer> wordToFreq = new HashMap<>();
        for (String word : words) {
            wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - wordNum * wordLen; i++) {
            Map<String, Integer> copyMap = new HashMap<>(wordToFreq);
            int matched = 0;
            for (int index = i; index < i + wordNum * wordLen; index += wordLen) {
                String sub = s.substring(index, index + wordLen);
                if (!copyMap.containsKey(sub) || copyMap.get(sub) < 1) break;
                copyMap.put(sub, copyMap.get(sub) - 1);
                matched++;
            }
            if (matched == wordNum) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords a = new SubstringWithConcatenationOfAllWords();
        System.out.println(a.findSubstring("wordgoodgoodgoodbestword",
        new String[] {"word","good","best","good"}));
    }

}
