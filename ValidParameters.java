import java.util.Stack;

public class ValidParameters {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                char open = stack.pop();
                if (!(open == '(' && c == ')') &&
                        !(open == '[' && c == ']') &&
                        !(open == '{' && c == '}')) {
                    System.out.println("here" + " open " + open + " c " + c);
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        ValidParameters a = new ValidParameters();
        System.out.println(a.isValid("[](){}"));
    }
}
