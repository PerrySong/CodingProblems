import java.util.*;

public class RepeatedDNASequences {
    /**
     *
         All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

         Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

         Example:

         Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

         Output: ["AAAAACCCCC", "CCCCCAAAAA"]
     */

    private final double SIZE_POW_9 = Math.pow(4, 9);
    private final static Map<Character, Integer> map = new HashMap<>();
    static {map.put('A', 0); map.put('T', 1); map.put('C', 2); map.put('G', 3);}
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        double hashcode = 0;
        char[] cArr = s.toCharArray();
        Set<Double> hashcodes = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {

            if(i > 9) {
                hashcode -= SIZE_POW_9 * map.get(cArr[i - 10]);
            }
            hashcode = hashcode * 4 + map.get(cArr[i]);

            if(i > 8) {
                if(!hashcodes.add(hashcode))
                    res.add(s.substring(i - 9, i + 1));
            }
        }
        return new ArrayList<>(res);
    }
}
