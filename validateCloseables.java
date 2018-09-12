import java.util.Stack;

public class validateCloseables {

    public boolean valid(String s) {
        if (s == null) return false;
        char[] cArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : cArr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                char topC = stack.pop();
                if (
                        topC == '(' && c != ')' ||
                        topC == '[' && c != ']' ||
                        topC == '{' && c != '}'
                        ) {
                    return false;
                }
            }
        }
        return true;
    }
}
