import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.equals(""))
            return res;
        helper(digits, 0, res, new StringBuilder());
        return res;
    }

    public void helper(String input, int cur, List<String> res, StringBuilder s) {
        if(s.length() == input.length()) {
            res.add(new String(s));
            return;
        }
        char[][] letters = new char[10][];
        letters[0] = new char[]{' '};

        letters[2] = new char[]{'a', 'b', 'c'};
        letters[3] = new char[]{'d', 'e', 'f'};
        letters[4] = new char[]{'g', 'h', 'i'};
        letters[5] = new char[]{'j', 'k', 'l'};
        letters[6] = new char[]{'m', 'n', 'o'};
        letters[7] = new char[]{'p', 'q', 'r', 's'};
        letters[8] = new char[]{'t', 'u', 'v'};
        letters[9] = new char[]{'w', 'x', 'y', 'z'};

            for(char letter: letters[input.charAt(cur) - '0']) {
                s.append(letter);
                helper(input, cur + 1, res, s);
                s.deleteCharAt(s.length() - 1);
            }

    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber a = new LetterCombinationsOfAPhoneNumber();
        System.out.println(a.letterCombinations(""));
    }
}
