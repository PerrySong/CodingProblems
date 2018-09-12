import java.util.ArrayList;
import java.util.List;

public class BasicCalculator {
    /**
         Implement a basic calculator to evaluate a simple expression string.

         The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

         Example 1:

         Input: "3+2*2"
         Output: 7
         Example 2:

         Input: " 3/2 "
         Output: 1
         Example 3:

         Input: " 3+5 / 2 "
         Output: 5
         Note:

         You may assume that the given expression is always valid.
         Do not use the eval built-in library function.
     */

//     public int calculate(String s) {
//         if (s == null) return 0;
//         s = s.replaceAll("\\s+", "");
//         Stack<Integer> stack = new Stack<>();
//         char sign = '+';


//         int len = s.length();
//         for (int i = 0; i < len; i++) {
//             int num = 0;
//             while (i < len && Character.isDigit(s.charAt(i))) { //while next char is also digit
//                 num *= 10;
//                 num += s.charAt(i) - '0';
//                 i++;
//             }
//             if (sign == '+') {
//                 stack.push(num);
//             } else if (sign == '-') {
//                 stack.push(-num);
//             } else if (sign == '*') {
//                 stack.push(stack.pop() * num);
//             } else if (sign == '/') {
//                 stack.push(stack.pop() / num);
//             }
//             if (i < len)
//                 sign = s.charAt(i);
//         }
//         int res = 0;
//         while (!stack.isEmpty()) {
//             res += stack.pop();
//         }
//         return res;
//     }

    // 3+2*2
    //tmp 3
    //cur 2
    //res 0
    // nextSign *
    //sign +
    // i 3
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.replaceAll("\\s+", "");
        int res = 0, tmp = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            int cur = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                cur = cur * 10 + (s.charAt(i) - '0');
                i++;
            }

            if (sign == '*') {
                tmp = tmp * cur;
            } else if (sign == '/') {
                tmp = tmp / cur;
            } else if (sign == '+') {
                res += tmp;
                tmp = cur;
            } else if (sign == '-') {
                res += tmp;
                tmp = -cur;
            }

            if (i < s.length())
                sign = s.charAt(i);
        }
        res += tmp;
        return res;

    }

    public static void main(String[] args) {
        System.out.println("abc".startsWith("a"));
        BasicCalculator a = new BasicCalculator();
        System.out.println(a.calculate(" 3+5 / 2 "));
    }
}
