import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    /**
         Given a string containing only digits, restore it by returning all possible valid IP address combinations.

         Example:

         Input: "25525511135"
         Output: ["255.255.11.135", "255.255.111.35"]
     */

    /**
     1. The length of the ip without '.' should be equal to the length of s;
     2. The digit order of ip should be same as the digit order of s;
     3. Each part separated by the '.' should not start with '0' except only '0';
     4. Each part separared by the '.' should not larger than 255;
     */

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (s == null || len < 4 || len > 12) return res;
        for (int i = 1; i < 4 && i <= len - 3; i++) {
            if (len - i > 9) continue;
            if (len - i < 3) break;
            for (int j = i + 1; j < i + 4 && j <= len - 2; j++) {
                if (len - j > 6) continue;
                if (len - j < 2) break;
                for (int k = j + 1; k < j + 4 && k <= len - 1; k++) {
                    if (len - k > 3) continue;
                    if (len - k < 1) break;
                    for (int l = k + 1; l < k + 4 && l <= len; l++) {
                        int first = Integer.valueOf(s.substring(0, i)),
                                second = Integer.valueOf(s.substring(i, j)),
                                third = Integer.valueOf(s.substring(j, k)),
                                fourth = Integer.valueOf(s.substring(k, l));
                        if (first <= 255 &&
                                second <= 255 &&
                                third <= 255 &&
                                fourth <= 255) {

                            String ip = first + "." + second + "." + third + "." + fourth;
                            if (ip.length() == s.length() + 3)
                                res.add(ip);
                        }

                    }
                }
            }
        }
        return res;
    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        dfsValidIp(res, "", s, 0, 0);
        return res;
    }

    private void dfsValidIp(List<String> res, String tmpIp, String s, int index, int level) {
        // Base case
        if (index == s.length() && level == 4) {
            res.add(tmpIp.substring(1));
            return;
        }
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String partial = s.substring(index, index + i);
            int val = Integer.valueOf(partial);
            if (val == 0) {
                dfsValidIp(res, tmpIp + "." + partial, s, index + i, level + 1);
                break;
            } else if (val <= 255) {
                dfsValidIp(res, tmpIp + "." + partial, s, index + i, level + 1);
            }
        }
    }
}
