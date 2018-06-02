import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistanceIII {

    /**
     *
     *
         Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

         word1 and word2 may be the same and they represent two individual words in the list.

         Example:
         Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

         Input: word1 = “makes”, word2 = “coding”
         Output: 1
         Input: word1 = "makes", word2 = "makes"
         Output: 3
         Note:
         You may assume word1 and word2 are both in the list.

     */

    public int shortestWordDistance(String[] words, String word1, String word2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1))
                list1.add(i);
            if(words[i].equals(word2))
                list2.add(i);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < list1.size(); i++) {
            for(int j = 0; j < list2.size(); j++) {
                if(list1.get(i) == list2.get(j)) continue;
                if(list1.get(i) < list2.get(j)) {
                    res = Math.min(res, list2.get(j) - list1.get(i));
                    break;
                }
                if(list1.get(i) > list2.get(j)) {
                    res = Math.min(res, list1.get(i) - list2.get(j));
                }
            }
        }
        return res;
    }
}
