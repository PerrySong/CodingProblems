public class SudokuSolver {
    /**
         Write a program to solve a Sudoku puzzle by filling the empty cells.

         A sudoku solution must satisfy all of the following rules:

         Each of the digits 1-9 must occur exactly once in each row.
         Each of the digits 1-9 must occur exactly once in each column.
         Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
         Empty cells are indicated by the character '.'.


         A sudoku puzzle...


         ...and its solution numbers marked in red.

         Note:

         The given board contain only digits 1-9 and the character '.'.
         You may assume that the given Sudoku puzzle will have a single unique solution.
         The given board size is always 9x9.


        Time: O(9 ^ m) //m is the blanks
        Space: O(1)
     */

    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';

                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for(int i = 0; i < board.length; i++) {
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
            if(board[3 * (row/3) + i /3][3 * (col/3) + i % 3] == c) return false;
        }
        return true;
    }
}
