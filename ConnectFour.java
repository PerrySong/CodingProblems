public class ConnectFour {
    private int[][] board;
    private int win;
    private int player;


    public ConnectFour(int col, int row, int win) {
        this.board = new int[col][row];
        this.win = win;
        this.player = 1;
    }

    public void play(int col) {
        int index = 0;
        // System.out.println(col);
        for (int i = 0; i < board.length; i++) {
            if (board[col][i] == 0) break;
            index++;
        }
        if (index < board[col].length) {
            board[col][index] = this.player;

            if (player == 1)
                player = 2;
            else
                player = 1;
        }

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

    public boolean over() {
        int length = 0;
        int curPlayer = 0;
        //check row
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0 && board[i][j] == curPlayer) length++;
                else {
                    curPlayer = board[i][j];
                    length = 1;
                }
                if (length >= this.win) return true;
            }
        }

        //Check col
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0 && board[i][j] == curPlayer) length++;
                else {
                    curPlayer = board[i][j];
                    length = 1;
                }
                if (length >= this.win) return true;
            }
        }


        return false;
    }




    public static void main(String[] args) {
        ConnectFour cf = new ConnectFour(7,6,4);
        for (int i = 0; i < 42; i++) {

            cf.play((int)(Math.random() * 7));
            System.out.println();
            cf.print();
        }
        System.out.println("Hello world!");
    }
}
