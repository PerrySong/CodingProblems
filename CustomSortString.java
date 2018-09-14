import java.util.Arrays;
import java.util.Comparator;

public class CustomSortString {
    /**
         S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

         S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

         Return any permutation of T (as a string) that satisfies this property.

         Example :
         Input:
         S = "cba"
         T = "abcd"
         Output: "cbad"
         Explanation:
         "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
         Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.


         Note:

         S has length at most 26, and no character is repeated in S.
         T has length at most 200.
         S and T consist of lowercase letters only.
     */
    
    // Use a bucket to store T
    // Loop through S and append char from bucket
    public String customSortString(String S, String T) {
        if (S == null || T == null) return T;
        StringBuilder sb = new StringBuilder();

        // Put T to bucket
        int[] tCharCount = new int[26];
        for (char c : T.toCharArray()) {
            tCharCount[c - 'a']++;
        }

        // Append char according S's char order
        for (char c : S.toCharArray()) {
            int count = tCharCount[c - 'a'];
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
            tCharCount[c - 'a'] = 0;
        }

        // Append rest of the chars
        for (int i = 0; i < tCharCount.length; i++) {
            while (tCharCount[i]-- > 0) {
                sb.append((char)(i + 'a'));
            }
        }

        return sb.toString();
    }
}
