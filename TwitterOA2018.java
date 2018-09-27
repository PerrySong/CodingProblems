import java.util.*;

public class TwitterOA2018 {

    private static final String NO = "NO";
    private static final String YES = "YES";
    static String[] braces(String[] values) {
        String[] res = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            if (isValidGroup(values[i]))
                res[i] = YES;
            else
                res[i] = NO;
        }
        return res;
    }

    static boolean isValidGroup(String group) {
        if (group == null || group.length() == 0 || group.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < group.length(); i++) {
            if (group.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (group.charAt(i) == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            } else if (group.charAt(i) == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
            }
        }
        return stack.isEmpty();
    }



    static void textQueries(List<String> sentences, List<String> queries) {
        if (sentences == null || queries == null || sentences.size() == 0 || queries.size() == 0) return;
        List<Map<String, Integer>> wordMapList = new ArrayList<>();
        Map<String, Map<Integer, Integer>> wordToSentenceTo = new HashMap<>();
        Map<String, Set<Integer>> wordApears = new HashMap<>(); // key = word, value = sentences it appears
        // Build map wordToFreq for sentance, key = word, value = frequence
        for (int i = 0; i < sentences.size(); i++) {
            String sentence = sentences.get(i);
            String[] words = sentence.split("\\s+");
            Map<String, Integer> wordToFreq = new HashMap<>();
            for (String word : words) {
                wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
                wordApears.getOrDefault(word, new HashSet<Integer>()).add(i);
            }
            wordMapList.add(wordToFreq);
        }

        // Traverse the queries
        for (String query : queries) {
            // Build the current query wordMap, key = word, value = frequence
            boolean found = false; // Indicates whether we found result for current query
            String[] words = query.split("\\s+");
            Map<String, Integer> qWordToFreq = new HashMap<>();
            for (String word : words) {
                qWordToFreq.put(word, qWordToFreq.getOrDefault(word, 0) + 1);
            }
            // Traverse the wordMapList
            for (int i : wordApears.get(words[0])) {
                Map<String, Integer> sWordToFreq = wordMapList.get(i);
                // count records the current query shows time
                int count = Integer.MAX_VALUE;
                for (String key : qWordToFreq.keySet()) {
                    if (!sWordToFreq.containsKey(key)) {
                        count = 0;
                        break;
                    }  //
                    int qFreq = qWordToFreq.get(key);
                    int sFreq = sWordToFreq.get(key);
                    count = Math.min(count, sFreq / qFreq);
                    if (count == 0) break;    // The count's min possible value is 0,
                }
                if (count > 0) found = true;
                for (int j = 0; j < count; j++)
                    System.out.print(i + " ");

            }
            if (!found) System.out.print(-1 + " ");
            System.out.println();
        }

    }




//    static void textQueries(List<String> sentences, List<String> queries) {
//        if (sentences == null || queries == null || sentences.size() == 0 || queries.size() == 0) return;
//        List<Map<String, Integer>> wordMapList = new ArrayList<>();
//        Map<String, Map<Integer, Integer>> wordToSentenceToFreq = new HashMap<>();
//        // Build map wordToSentenceToFreq for sentance, key = word, value = sentenceToFreq < key = sentenceId, value = frequence >
//
//        for (int i = 0; i < sentences.size(); i++) {
//            String sentence = sentences.get(i);
//            String[] words = sentence.split("\\s+");
//            for (String word : words) {
//                if (!wordToSentenceToFreq.containsKey(word)) wordToSentenceToFreq.put(word, new HashMap<>());
//                Map<Integer, Integer> sentenceToFreq = wordToSentenceToFreq.get(word);
//                sentenceToFreq.put(i, sentenceToFreq.getOrDefault(i, 0) + 1);
//            }
//        }
//
//        // Traverse the queries
//        for (String query : queries) {
//            // Build the current query wordMap, key = word, value = frequence
//            boolean found = false; // Indicates whether we found result for current query
//            String[] words = query.split("\\s+");
//            Map<String, Integer> qWordToFreq = new HashMap<>();
//            for (String word : words) {
//                qWordToFreq.put(word, qWordToFreq.getOrDefault(word, 0) + 1);
//            }
//            // Traverse the wordMapList
//
//
//
//            if (!found) System.out.print(-1 + " ");
//            System.out.println();
//        }
//
//    }
//
//    static List<Integer> query(Map<String, Integer> query, Map<String, Map<Integer, Integer>> wordToSentenceToFreq) {
//        Map<Integer, Integer> resultMap = new HashMap<>(); // key = sentence id, value = freqence
//
//    }


}
