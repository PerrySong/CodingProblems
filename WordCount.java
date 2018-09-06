import java.util.HashMap;

public class WordCount {

    public HashMap<String, Integer> wordCount(String s) {
        String[] words = s.split("\\s+");
        HashMap<String, Integer> res = new HashMap<>();
        for (String word : words) {
            res.put(word, res.getOrDefault(word, 0) + 1);
        }
        return res;
    }
}
