import java.util.Stack;

public class BackspaceStringCompare {
    /**
         Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.



         Example 1:

         Input: S = "ab#c", T = "ad#c"
         Output: true
         Explanation: Both S and T become "ac".
         Example 2:

         Input: S = "ab##", T = "c#d#"
         Output: true
         Explanation: Both S and T become "".
         Example 3:

         Input: S = "a##c", T = "#a#c"
         Output: true
         Explanation: Both S and T become "c".
         Example 4:

         Input: S = "a#c", T = "b"
         Output: false
         Explanation: S becomes "c" while T becomes "b".

     */

//    public boolean backspaceCompare(String S, String T) {
//        if(S == null || T == null) return false;
//        int i = S.length() - 1, j = T.length() - 1;
//        int skip1 = 0, skip2 = 0;
//        while(i >= 0 || j >= 0) {
//
//            while(i >= 0 || skip1 > 0) {
//                if(i >= 0 && S.charAt(i) == '#') {
//                    i --;
//                    skip1++;
//                    continue;
//                } else if(skip1 > 0){
//                    i--;
//                    skip1--;
//                    continue;
//                }
//                break;
//            }
//
//            while(j >= 0 || skip2 > 0) {
//                if(j >= 0 && T.charAt(j) == '#') {
//                    j--;
//                    skip2++;
//                    continue;
//                } else if(skip2 > 0){
//                    j--;
//                    skip2--;
//                    continue;
//                }
//                break;
//            }
//            if(i < 0 && j < 0) break;
//            if(skip1 == 0 && skip2 == 0) {
//                if(i < 0 || j < 0 || S.charAt(i--) != T.charAt(j--)) return false;
//            }
//        }
//
//        return true;
//    }

    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return false;
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for(char c : S.toCharArray()) {
            if (c == '#') {
                if (!sStack.isEmpty())
                    sStack.pop();
            } else
                sStack.push(c);
        }

        for(char c : T.toCharArray()) {
            if (c == '#') {
                if (!tStack.isEmpty())
                    tStack.pop();
            } else
                tStack.push(c);
        }

        System.out.println(sStack.size() + " " + tStack.size());
        if (sStack.size() != tStack.size()) return false;
        while (!sStack.isEmpty()) {
            if (!sStack.pop().equals(tStack.pop())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare a = new BackspaceStringCompare();
        System.out.println(a.backspaceCompare("xywrrmp",
                "xywrrmu#p"));
    }
}
