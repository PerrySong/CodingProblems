public class ConnectFour {
    private int[][] board;
    //board : 0 : empty, 1 : player1, 2 : player2
    private int win;
    private int player;


    public ConnectFour(int row, int col, int win) {
        this.board = new int[row][col];
        this.win = win;
        this.player = 1;
    }

    /**
     *
     * @param col
     * @return The current element's position, [-1, -1] if player can not place the move
     */
    public int[] play(int col) {
        int[] pos = new int[2];
        int row = 0;
        // System.out.println(col);
        for (; row < board.length; row++) {
            //Find the first empty space
            if (board[row][col] == 0) break;
        }

        if (row < board.length) {
            board[row][col] = this.player;

            if (player == 1)
                player = 2;
            else
                player = 1;
            return new int[] {row, col};
        }
        return new int[] {-1, -1};

    }

    public void print() {

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print('O');
                } else if (board[i][j] == 2) {
                    System.out.print('X');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }

    /**
     * i, j is the position in the board, return 0 if the game is not yet over, 1 if player1 win and 2 if player2 win
     * @param i
     * @param j
     * @return winner (1 or 2), not yet finished: 0, finish but no winner: -1
     */
    public int winner(int i, int j) {

        if (boardFull()) return -1;
        //Check row
        // left side consecutive + itself + right side consecutive
        if (rowConsecutive(i, j, -1) + 1 + rowConsecutive(i, j, 1) >= win) return board[i][j];
        // Bottom consecutive + itself +
        if (colConsecutive(i, j, -1) + 1 + colConsecutive(i, j, 1) >= win) return board[i][j];
        // Check two way diagonals
        if (diagonalConsecutive(i + 1, j + 1, 1, 1) + 1 + diagonalConsecutive(i - 1, j - 1, -1, -1) >= win) return board[i][j];
        if (diagonalConsecutive(i - 1, j + 1, -1, 1) + 1 + diagonalConsecutive(i + 1, j - 1, 1, -1) >= win) return board[i][j];
        System.out.print("cons: ");
        System.out.println(rowConsecutive(i, j, -1) + 1 + rowConsecutive(i, j, 1));
        return 0;
    }

    /**
     * Return how many consecutive consecutive elements in the row with given increment
     */
    private int rowConsecutive(int row, int col, int increment) {
        int player = this.board[row][col];
        if (player == 0) return 0;

        int res = 0;
        for (; col + increment < board[0].length && col + increment >= 0 && board[row][col + increment] == board[row][col]; col += increment, res += 1);

        return res;
    }

    /**
     * Return how many consecutive consecutive elements in the col with given increment
     */
    private int colConsecutive(int row, int col, int increment) {
        int player = this.board[row][col];
        if (player == 0) return 0;

        int res = 0;
        for (; row + increment < board.length && row + increment >= 0 && board[row  + increment][col] == board[row][col]; row += increment, res += 1);
        return res;
    }

    /**
     *
     * @param row
     * @param col
     * @param ver: Indicate vertical direction: +1: up, -1: down
     * @param hor: Indicate horizontal direction, +1: top heads to right, -1: top heads to left
     * @return
     */
    private int diagonalConsecutive(int row, int col, int ver, int hor) {
        if (row >= board.length || col >= board.length || row < 0 || col < 0 || board[row - ver][col - hor] != board[row][col]) return 0;
        return 1 + diagonalConsecutive(row + ver, col + hor, ver, hor);
    }


    private boolean boardFull() {
        for (int col = 0; col < board[0].length; col++) {
            if (board[board.length - 1][col] == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ConnectFour cf = new ConnectFour(9,9,5);
        System.out.println("Player1 moves \"O\" and Player2 two moves \"X\"");
        while (true) {
            int[] pos;
            while ((pos = cf.play((int)(Math.random() * 7)))[0] == -1);

            System.out.println();
            cf.print();
            int winner;
            if ((winner = cf.winner(pos[0], pos[1])) != 0) {
                if (winner == -1) { //No winner and game is finished
                    System.out.println("No winner and the game is finished");
                    break;
                } else {
                    System.out.println("Winner is player" + winner);
                    System.out.println("Player1 moves \"O\" and Player2 two moves \"X\"");
                    break;
                }
            }
        }
    }
}
