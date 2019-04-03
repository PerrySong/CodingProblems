import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    /*
        Input: "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    private Map<Character, Integer> romanToInt;

    /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
    */
    public RomanToInt() {
        this.romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);
    }
    // Assume s is a valid input, only contains I, V, X, L, C, D, M
    // "MCMXCIV"
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] cArr = s.toCharArray();

        int res = 0, curSum = romanToInt.get(cArr[0]);
        for (int i = 1; i < cArr.length; i++) {
            char c = cArr[i];
            int cur = romanToInt.get(c);
            if (curSum < cur) {
                res += cur - curSum;
                curSum = 0;
            } else {
                curSum += cur;
            }
        }
        res += curSum;
        return res;
    }

    public static void main(String[] args) {
        RomanToInt a = new RomanToInt();
        System.out.println(a.romanToInt("IV"));
    }
}
