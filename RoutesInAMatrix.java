import java.util.Arrays;

public class RoutesInAMatrix {
    public static double numberOfRoutes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows + 1][columns + 1];

//        Arrays.fill(dp, 0);
        dp[0][1] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1)
                    dp[i + 1][j + 1] = dp[i][j + 1]  + dp[i + 1][j];
                else
                    dp[i + 1][j + 1] = 0;

                if (dp[i + 1][j + 1] >= Math.pow(10, 9) + 7) return Math.pow(10, 9) + 7;
            }
        }

        return dp[rows][columns];
    }

    public static void main(String[] args) {
        System.out.println(numberOfRoutes(new int[][] {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
    }
}
