public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        return blockValid(board) && columnValid(board) && rowValid(board);
    }

    public static boolean blockValid(char[][] board) {
        for(int i = 0; i < board.length - 3; i += 3) {
            for(int j = 0; j < board[0].length - 3; j += 3) {
                int[] nums = new int[9];
                for(int r = i; r < i + 3; r++) {
                    for(int c = j; c < j + 3; c++) {
                        if(board[r][c] == '.') continue;
                        int num = Integer.valueOf(board[r][c]) - Integer.valueOf('1');
                        System.out.println("num = " +  num);
                        if(num > 9 || nums[num] != 0) return false;
                        nums[num]++;
                    }
                }
            }
        }
        return true;
    }

    public static boolean columnValid(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            int[] nums = new int[9];
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') continue;

                int num = Integer.valueOf(board[i][j]) - Integer.valueOf('1');
                System.out.println("num = " +  num);
                if(num > 9 || nums[num] != 0) return false;
                nums[num]++;
            }
        }
        return true;
    }
    public static boolean rowValid(char[][] board) {
        for(int j = 0; j < board[0].length; j++) {
            int[] nums = new int[9];
            for(int i = 0; i < board.length; i++) {
                if(board[i][j] == '.') continue;
                int num = Integer.valueOf(board[i][j]) - Integer.valueOf('1');
                System.out.println("num = " +  num);
                if(num > 9 || nums[num] != 0) return false;
                nums[num]++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
        System.out.println(columnValid(board));
        System.out.println(rowValid(board));
        System.out.println(blockValid(board));
    }
}
