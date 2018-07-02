public class ShortestWordDistance {
    /**
         Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

         Example:
         Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

         Input: word1 = “coding”, word2 = “practice”
         Output: 3
         Input: word1 = "makes", word2 = "coding"
         Output: 1
         Note:
         You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
     */

    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || word1 == null || word2 == null) return -1;
        int i1 = -1, i2 = -1;
        int res = words.length - 1;
        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(word1)) {
                i1 = i;
            }
            if (words[i].equals(word2)) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i1 - i2));
            }

        }
        return res;
    }
}
