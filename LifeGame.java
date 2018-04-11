public class LifeGame {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int lives = lives(board, board.length, board[0].length, i, j);
                if(lives >= 2 && lives <= 3 && board[i][j] == 1)
                    board[i][j] = 3;
                if(lives == 3 && board[i][j] == 3)
                    board[i][j] = 2;
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public int lives(int[][] board, int m, int n, int i, int j) {
        int res = 0;
        for(int r = Math.max(0, i - 1); r < Math.min(n, i + 1); r++) {
            for(int c = Math.max(0, j - 1); c < Math.min(m, j + 1); c++) {
                res += board[r][c] & 1;
            }
        }
        res -= board[i][j];
        return res;
    }
}
