import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KdistinctSubstring {
    public static int kDistinctSubstring(String str, int k) {
        if (k > 26 || str == null || str.length() < k) return 0;
        int res = 0;
        char[] cArr = str.toCharArray();

        for (int i = 0; i < cArr.length; i++) {
            Set<Character> cSet = new HashSet<>();
            int count = 0;
            for (int j = i; j < cArr.length; j++) {
                if (cSet.add(cArr[j])) {
                    count++;
                }
                if (count == k)
                    res++;
                if (count > k)
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "hi i'am perry";
        System.out.println(kDistinctSubstring(str, 4));
    }
}
