public class WordSearch {

    /**
     *
         Given a 2D board and a word, find if the word exists in the grid.

         The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

         Example:

         board =
         [
         ['A','B','C','E'],
         ['S','F','C','S'],
         ['A','D','E','E']
         ]

         Given word = "ABCCED", return true.
         Given word = "SEE", return true.
         Given word = "ABCB", return false.
     */

    public boolean exist(char[][] board, String word) {
        if (word == null || board == null || board.length == 0 || board[0].length == 0) return false;
        if (word.length() > board.length * board[0].length) return false;

        char[] cArray = word.toCharArray();


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == cArray[0] && search(board, cArray, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, char[] cArray, int i, int j, int index) {
        System.out.println(i + " " + j);
        if (i >= board.length || i <= 0 || j >= board[0].length || j <= 0 || index >= cArray.length || board[i][j] != cArray[index]) return false;
        if (index == cArray.length  && cArray[index] == board[i][j]) return true;

        return (search(board, cArray, i + 1, j, index + 1) || search(board, cArray, i - 1, j, index + 1) || search(board, cArray, i, j + 1, index + 1) || search(board, cArray, i, j - 1, index + 1));
    }

}
