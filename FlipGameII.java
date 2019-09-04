import java.util.HashMap;
import java.util.Map;

public class FlipGameII {
    /**
     AmazonDebug 1:
     Recursion
     T(N) = (N - 1) * T(N - 2) = (N - 1) * (N - 3) * T(N - 4) = (N - 1) !

     canWin("++++++") = !canWin("--++++") || !canWin("+--+++") || !canWin("++--++") || !canWin("+++--+") || !canWin("++++--")

     AmazonDebug 2:
     Recursion + memoriztion

     */




    public boolean canWin(String s) {

        return canWinHelper(s.toCharArray(), new HashMap<>());
    }

    public boolean canWinHelper(char[] chars, Map<char[], Boolean> map) {
        if(map.get(chars) != null) {
            return map.get(chars);
        }

        boolean res = false;
        for(int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == '+' && chars[i + 1] =='+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                res = res || !canWinHelper(chars, map);
                chars[i] = '+';
                chars[i + 1] = '+';
            }

        }
        map.put(chars.clone(), res);
        return res;
    }

    public static void main(String[] args) {
        String input = "++++";
        FlipGameII a = new FlipGameII();
        a.canWin(input);
    }
}
