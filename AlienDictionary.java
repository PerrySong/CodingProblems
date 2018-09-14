import java.util.*;

public class AlienDictionary {
    /**
         There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

         Example 1:

         Input:
         [
         "wrt",
         "wrf",
         "er",
         "ett",
         "rftt"
         ]

         Output: "wertf"
         Example 2:

         Input:
         [
         "z",
         "x"
         ]

         Output: "zx"
         Example 3:

         Input:
         [
         "z",
         "x",
         "z"
         ]

         Output: ""

         Explanation: The order is invalid, so return "".
         Note:

         You may assume all letters are in lowercase.
         You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
         If the order is invalid, return an empty string.
         There may be multiple valid order of letters, return any one of them is fine.

     */

    // Topological sort
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        HashMap<Character, Set<Character>> dependencies = new HashMap<>(); //<c1, Set<chars that depends on c1>>
        int[] indegrees = new int[26];
        int count = 0;
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (indegrees[c - 'a'] == 0) {
                    indegrees[c - 'a'] = 1;
                    dependencies.put(c, new HashSet<>());
                    count++;
                }
            }
        }

        // Build the graph
        for (int i = 1; i < words.length; i++) {
            char[] cWord1 = words[i - 1].toCharArray();
            char[] cWord2 = words[i].toCharArray();
            int len = Math.min(cWord1.length, cWord2.length);
            for (int j = 0; j < len; j++) {
                char c1 = cWord1[j];
                char c2 = cWord2[j];
                if (c1 != c2) {
                    if (!dependencies.get(c1).contains(c2)) {
                        indegrees[c2 - 'a']++;
                        dependencies.get(c1).add(c2);
                    }
                    break;
                }
            }
        }

        //Bfs the chars
        Queue<Character> queue = new LinkedList<>();

        do {
            if (queue.isEmpty()) {
                for (int i = 0; i < indegrees.length; i++) {
                    if (indegrees[i] == 1)
                        queue.add((char)('a' + i));
                }
            }
            if (queue.isEmpty()) break;
            char curC = queue.poll();
            res.append(curC);
            if (indegrees[curC - 'a'] != 1) return "";
            indegrees[curC - 'a'] = 0;
            Set<Character> charSet = dependencies.get(curC);
            System.out.println(charSet);
            for (char dC : charSet) {
                indegrees[dC - 'a']--;
                if (indegrees[dC - 'a'] == 1) queue.offer(dC);
                if (indegrees[dC - 'a'] < 1) return "";
            }


        } while (!queue.isEmpty());

        System.out.println(res);
        if (res.length() != count) return "";
        return res.toString();
    }

    // Test case : ["aac","aabb","aaba"]
    // indegrees : a : 1, b : 1, c : 0
    // dep : {c : b},  {b, a}

    public static void main(String[] args) {
        AlienDictionary a = new AlienDictionary();
        a.alienOrder(new String[] {"wrt","wrf","er","ett","rftt","te"});
    }
}
