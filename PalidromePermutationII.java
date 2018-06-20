import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalidromePermutationII {
    /**
         Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

         Example 1:

         Input: "aabb"
         Output: ["abba", "baab"]
         Example 2:

         Input: "abc"
         Output: []
     */
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> cCount = new HashMap<>();
        List<String> res = new ArrayList<>();
        List<Character> cList = new ArrayList<>();

        int sLen = s.length();
        int odds = 0;
        for(int i = 0; i < sLen; i++) {
            char curC = s.charAt(i);
            if(cCount.containsKey(curC)) {
                cCount.put(curC, cCount.get(curC) + 1);
            } else {
                cCount.put(curC, 1);
            }
            odds += cCount.get(curC) % 2 == 0 ? -1 : 1;
        }

        if(odds > 1) return res;
        String mid = "";
        for(Map.Entry<Character, Integer> entry: cCount.entrySet()) {
            char c = entry.getKey();
            int num = entry.getValue();
            if(num%2 != 0) mid += c;
            for(int i = 0; i < num/2; i++)
                cList.add(c);
        }


        helper(res, cList, mid, new boolean[cList.size()], new StringBuilder());
        return res;

    }

    private void helper(List<String> res, List<Character> cList, String mid, boolean[] used, StringBuilder sb) {
        if(sb.length() == cList.size()) {
            String s = sb.toString() + mid;
            sb.reverse();
            s += sb;
            res.add(s);
            sb.reverse();
            return;
        }

        for(int i = 0; i < cList.size(); i++) {
            if(used[i]) continue;
            if(i > 0 && cList.get(i) == cList.get(i - 1) && !used[i - 1]) continue;
            sb.append(cList.get(i));
            used[i] = true;
            helper(res, cList, mid, used, sb);
            used[i] = false;
            sb = sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        PalidromePermutationII a = new PalidromePermutationII();
        a.generatePalindromes("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
