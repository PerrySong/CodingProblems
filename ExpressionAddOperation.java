import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperation {
    /**
         Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

         Example 1:

         Input: num = "123", target = 6
         Output: ["1+2+3", "1*2*3"]
         Example 2:

         Input: num = "232", target = 8
         Output: ["2*3+2", "2+3*2"]
         Example 3:

         Input: num = "105", target = 5
         Output: ["1*0+5","10-5"]
         Example 4:

         Input: num = "00", target = 0
         Output: ["0+0", "0-0", "0*0"]
         Example 5:

         Input: num = "3456237490", target = 9191
        Output: []
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        // 1. partition the numbers
        List<List<Long>> partitions = new ArrayList<>();
        partition(partitions, new ArrayList<>(), num); // n!

        // 2. try different operator
        for (List<Long> numsList : partitions) { // m
            List<String> formulars = new ArrayList<>();
            formFormulars(formulars, new StringBuilder(), numsList, 0); // O(3 ^ k)
            for (String formular : formulars) {

                if (result(formular) == (long)target) {
                    System.out.println(formular);
                    System.out.println(result(formular));
                    res.add(formular); // O(n)
                }
            }
        }
        return res;
    }

    public void partition(List<List<Long>> res, List<Long> tmp, String num) {
        if (num.length() == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 1; i <= num.length(); i++) {
            String curNUm = num.substring(0, i);
            if (curNUm.charAt(0) == '0' && i > 1) continue;
            tmp.add(Long.valueOf(curNUm));
            partition(res, tmp, num.substring(i));
            tmp.remove(tmp.size() - 1);
        }
    }

    public void formFormulars(List<String> res, StringBuilder tmp, List<Long> numList, int start) {
        int oriSize = tmp.length();
        tmp.append(numList.get(start));
        if (start >= numList.size() - 1) {
            res.add(tmp.toString());
            tmp.delete(oriSize, tmp.length());
            return;
        }
        char[] ops = new char[] {'+', '-', '*'};
        for (char op : ops) {
            tmp.append(op);
            formFormulars(res, tmp, numList, start + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        tmp.delete(oriSize, tmp.length());
    }

    public long result(String formular) {
        int res = 0;
        char[] ops = getOps(formular);
        String[] nums = formular.split("[^0-9]"); // Will generate an empty "" in the front
        if (nums.length == 1) return Long.valueOf(nums[0]);
        Stack<Long> stack = new Stack<>();
        stack.push(Long.valueOf(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            if (ops[i - 1]== '+') {
                stack.push(Long.valueOf(nums[i]));
            } else if (ops[i - 1]== '-') {
                stack.push(-Long.valueOf(nums[i]));
            } else if (ops[i - 1]== '*') {
                stack.push(stack.pop() * Long.valueOf(nums[i]));
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public char[] getOps(String formular) {
        int size = 0;
        for (char c : formular.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                size++;
            }
        }

        char[] res = new char[size];
        int i = 0;
        for (char c : formular.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                res[i++] = c;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ExpressionAddOperation a = new ExpressionAddOperation();
//        a.addOperators("3456237490",9191);
//        a.addOperators("105", 5);
        a.addOperators("2147483648",
                -2147483648);
//        System.out.println(a.result("10-5"));
    }
}
