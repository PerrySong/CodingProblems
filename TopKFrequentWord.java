import java.util.*;

public class TopKFrequentWord {
    /**
         Given a non-empty list of words, return the k most frequent elements.

         Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

         Example 1:
         Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
         Output: ["i", "love"]
         Explanation: "i" and "love" are the two most frequent words.
         Note that "i" comes before "love" due to a lower alphabetical order.
         Example 2:
         Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
         Output: ["the", "is", "sunny", "day"]
         Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
         with the number of occurrence being 4, 3, 2 and 1 respectively.
         Note:
         You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
         Input words contain only lowercase letters.
         Follow up:
         Try to solve it in O(n log k) time and O(n) extra space.
     */
    // Try to solve it in O(n log k) time and O(n) extra space.
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int[] frequences = new int[k];
        Map<String, Integer> wordToFreq = new HashMap<>(); //Record the frequence for each word
        for (String word : words) {
            wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
            int curFreq = wordToFreq.get(word);
            insert(frequences, curFreq);
        }

        int kthFreq = frequences[0];

        for (String word : wordToFreq.keySet()) {
            if (wordToFreq.get(word) >= kthFreq) res.add(word);
        }

        Collections.sort(res, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (wordToFreq.get(s1) != wordToFreq.get(s2)) {
                    return wordToFreq.get(s1) - wordToFreq.get(s2);
                }
                for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
                    if (s1.charAt(i) == s2.charAt(i)) continue;
                    return s1.charAt(i) - s2.charAt(i);
                }
                return s1.length() - s2.length();
            }
        });

        if (res.size() <= k) return res;
        return res.subList(0, k + 1);
    }



    // insert int to an int array with sorted order and pop the smmallest int
    // Should use binary search
    private static void insert(int[] array, int i) {
        for (int j = array.length - 1; j >= 0; j--) {
            if (array[j] <= i) {
                for (int k = 0; k < j; k++) {
                    array[k] = array[k + 1];
                }
                array[j] = i;
                break;
            }
        }
    }

    public static void main(String[] args) {
        topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
    }
}
