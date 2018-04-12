public class SetMatrixZero {

    //Brute solution
    public static void setZeroes(int[][] matrix) {
        boolean[] row0 = new boolean[matrix.length];
        boolean[] column0 = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row0[i] = true;
                    column0[j] = true;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            if(row0[i]) {
                for(int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if(column0[j]) {
                for(int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //O(1) space solution:
    public static void setZeroes2(int[][] matrix) {
        boolean row0 = false;
        boolean column0 = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(j == 0) row0 = true;
                    if(i == 0) column0 = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int row = 1; row < matrix.length; row++) {
            if(matrix[row][0] == 0) {
                for(int column = 0; column < matrix[0].length; column++) {
                    matrix[row][column] = 0;
                }
            }
        }
        for(int column = 1; column < matrix[0].length; column++) {
            if(matrix[0][column] == 0) {
                for(int row = 0; row < matrix.length; row++) {
                    matrix[row][column] = 0;
                }
            }
        }
        if(row0) {
            for(int row = 0; row < matrix.length; row++)
                matrix[row][0] = 0;
        }
        if(column0) {
            for(int column = 0; column < matrix[0].length; column++)
                matrix[0][column] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{0},{1}};
        setZeroes(a);
    }
}
