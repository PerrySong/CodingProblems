import java.util.ArrayList;
import java.util.List;

public class FindSecretWord {

    /**
     * LeetCode 843:
     *
     * This is an interactive problem.
     *
     * You are given an array of unique strings wordlist where wordlist[i] is 6 letters long, and one word in this list is chosen as secret.
     *
     * You may call Master.guess(word) to guess a word. The guessed word should have type string and must be from the original list with 6 lowercase letters.
     *
     * This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word. Also, if your guess is not in the given wordlist, it will return -1 instead.
     *
     * For each test case, you have exactly 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or fewer calls to Master.guess and at least one of these guesses was secret, then you pass the test case.
     *
     *
     *
     * Example 1:
     *
         * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"], numguesses = 10
         * Output: You guessed the secret word correctly.
         * Explanation:
         * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
         * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
         * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
         * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
         * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
         * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
     *
     * Example 2:
     *
         * Input: secret = "hamada", wordlist = ["hamada","khaled"], numguesses = 10
         * Output: You guessed the secret word correctly.
     *
     *
     * Constraints:
     *
         * 1 <= wordlist.length <= 100
         * wordlist[i].length == 6
         * wordlist[i] consist of lowercase English letters.
         * All the strings of wordlist are unique.
         * secret exists in wordlist.
         * numguesses == 10
     *
     *
     *

    **
     *
     * // This is the Master's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface Master {
     *     public int guess(String word) {}
     * }
     */

    class Master {
        // fake code for testing

        public int guess(String word) {
            return 6;
        }
    }

    // Sol1: pick first

    public void findSecretWord(String[] wordlist, Master master) {

        String word = wordlist[0];
        int matches = master.guess(word);
        if (matches == 6) {
            return;
        }
        List<String> wordlist2 = new ArrayList<>();
        for (int i = 1; i < wordlist.length; i++) {
            String curWord = wordlist[i];
            if (match(curWord, word) == matches) {
                wordlist2.add(curWord);
            }
        }
        findSecretWord(wordlist2.toArray(new String[wordlist2.size()]), master);
    }

    private int match(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            matches += (chars1[i] == chars2[i] ? 1 : 0);
        }
        return matches;
    }

    // Sol2: Maxmin
    // https://leetcode.com/problems/guess-the-word/discuss/133862/Random-Guess-and-Minimax-Guess-with-Comparison

    public void findSecretWord2(String[] wordlist, Master master) {
        int[][] charFreq = new int[6][26];
        for (String word : wordlist) {
            char[] charArr = word.toCharArray();
            for (int i = 0; i < 6; i++) {
                charFreq[i][charArr[i] - 'a'] += 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            // Pick the most representative word
            int maxScore = 0;
            String guess = "";
            for (String word : wordlist) {
                char[] charArr = word.toCharArray();
                int curScore = 0;
                for (int j = 0; j < 6; j++) {
                    curScore += charFreq[j][charArr[j] - 'a'];
                }
                if (curScore > maxScore) {
                    maxScore = curScore;
                    guess = word;
                }
            }
            int matches = master.guess(guess);
            if (matches == 6) {
                return;
            }

            List<String> wordlist2 = new ArrayList<>();
            for (String word : wordlist) {
                if (match(guess, word) == matches)
                    wordlist2.add(word);
            }
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }
}
