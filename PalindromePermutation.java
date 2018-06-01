public class PalindromePermutation {
    /**
     *
         Given a string, determine if a permutation of the string could form a palindrome.

         Example 1:

         Input: "code"
         Output: false
         Example 2:

         Input: "aab"
         Output: true
         Example 3:

         Input: "carerac"
         Output: true
     */
    public static boolean canPermutePalindrome(String s) {
        int[] counts = new int[256];
        for(char c: s.toCharArray()) {
            counts[c]++;
        }
        int odd = 0;
        for(int count: counts) {
            if(count % 2 != 0) odd++;
            if(odd > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        canPermutePalindrome("AaBb//a");
    }
}
