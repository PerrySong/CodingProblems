import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodWaysToSplitAString {
    // First solution
    public int numSplits(String s) {
        Map<Character, Integer> charToFreq1 = new HashMap<>();
        Map<Character, Integer> charToFreq2 = new HashMap<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            charToFreq2.put(c, charToFreq2.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            charToFreq1.put(c, charToFreq1.getOrDefault(c, 0) + 1);

            if (charToFreq2.containsKey(c)) {
                charToFreq2.put(c, charToFreq2.get(c) - 1);
                if (charToFreq2.get(c) == 0) {
                    charToFreq2.remove(c);
                }
            }

            if (charToFreq1.size() == charToFreq2.size()) {
                res++;
            }
        }
        return res;
    }
}
