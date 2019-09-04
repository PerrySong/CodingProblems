import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /**
         The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



         Given an integer n, return all distinct solutions to the n-queens puzzle.

         Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen
         and an empty space respectively.

         Example:

         Input: 4
         Output: [
         [".Q..",  // AmazonDebug 1
         "...Q",
         "Q...",
         "..Q."],

         ["..Q.",  // AmazonDebug 2
         "Q...",
         "...Q",
         ".Q.."]
         ]
         Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
     */

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n == 0) return res;
        int[] board = new int[n];
        helper(res, board, 0);
        return res;
    }

    private void helper(List<List<String>> res, int[] board, int pos) {
        if(pos == board.length) {
            res.add(convert(board));
            return;
        }
        for(int i = 0; i < board.length; i++) {
            board[pos] = i;
            if(!conflict(board, pos)) {
                helper(res, board, pos + 1);
            }
        }
    }

    private boolean conflict(int[] board, int pos) {
        for(int i = 0; i < pos; i++) {
            if(board[i] == board[pos])
                return true;
            if(Math.abs(pos - i) == Math.abs(board[i] - board[pos]))
                return true;
        }
        return false;
    }

    private List<String> convert(int[] board) {
        List<String> res = new ArrayList<>();
        for(int col: board) {
            StringBuilder row = new StringBuilder();
            for(int i = 0; i < board.length; i++) {
                if(i != col)
                    row.append(".");
                else
                    row.append("Q");
            }
            res.add(row.toString());
        }
        return res;
    }
}
