import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
    /**
         Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

         Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

         Example:
         Input:
         paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
         banned = ["hit"]
         Output: "ball"
         Explanation:
         "hit" occurs 3 times, but it is a banned word.
         "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
         Note that words in the paragraph are not case sensitive,
         that punctuation is ignored (even if adjacent to words, such as "ball,"),
         and that "hit" isn't the answer even though it occurs more because it is banned.

     */

    /** T(n) = O(n) */
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null) return null;
        String[] words = paragraph.split("[ !?',;.]"); // Will has "" in result for some reason

        Set<String> bannedSet = new HashSet(Arrays.asList(banned));

        HashMap<String, Integer> frequence = new HashMap<>();

        for (String word: words) {
            word = word.toLowerCase();
            if (!word.equals("") && !bannedSet.contains(word)) frequence.put(word, frequence.getOrDefault(word, 0) + 1);
        }

        int max = 0;
        String res = "";
        for (String word: frequence.keySet()) {
            if (frequence.get(word) > max) {
                max = frequence.get(word);
                res = word;
            }
        }
        return res;
    }
}
