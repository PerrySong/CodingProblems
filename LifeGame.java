public class LifeGame {
    public static void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int lives = lives(board, board.length, board[0].length, i, j);
                System.out.println("lives = " + lives);
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

    public static int lives(int[][] board, int m, int n, int i, int j) {
        int res = 0;
        for(int r = Math.max(0, i - 1); r <= Math.min(n - 1, i + 1); r++) {
            for(int c = Math.max(0, j - 1); c <= Math.min(m - 1, j + 1); c++) {
                res += board[r][c] & 1;
                System.out.println("res = " + res + " r = " + r + " c = " + c + " i = " + i + " j = " + j );
            }
        }
        res -= board[i][j];
        return res;
    }

    public static void printArray(int[][] arr) {
        for(int[] ar1: arr) {
            for(int i : ar1) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int[][] board = {{1, 1},{1, 0}};
        System.out.println("array[][] is : ");
        printArray(board);
        gameOfLife(board);
        printArray(board);
    }
}
