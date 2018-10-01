public class ReverseWordsInAString {
    /**
         Given an input string, reverse the string word by word.

         Example:

         Input: "the sky is blue",
         Output: "blue is sky the".
         Note:

         A word is defined as a sequence of non-space characters.
         Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
         You need to reduce multiple spaces between two words to a single space in the reversed string.
         Follow up: For C programmers, try to solve it in-place in O(1) space.
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] words = s.split("\\s+");
        if (words.length == 0) return "";
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i] != null && words[i].length() != 0)
                res.append(words[i]).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
