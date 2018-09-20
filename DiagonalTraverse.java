public class DiagonalTraverse {
    /**
         Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

         Example:
         Input:
         [
         [ 1, 2, 3 ],
         [ 4, 5, 6 ],
         [ 7, 8, 9 ]
         ]
         Output:  [1,2,4,7,5,3,6,8,9]
         Explanation:

         Note:
         The total number of elements of the given matrix will not exceed 10,000.

     */
    // 1 2 3
    // 1 2 3
    // 1 2 3
    // 1 2 3

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int curD = 1;

        int i = 0, j = 0, k = 0;

        while (k < res.length) {
            while (i >= 0 && i < rows && j >= 0 && j < cols) {
                res[k++] = matrix[i][j];
                i -= curD;
                j += curD;
            }

            if (i >= rows) {
                i = rows - 1;
                j += 2;
            }
            if (j >= cols) {
                j = cols - 1;
                i += 2;
            }

            if (i < 0) i = 0;
            if (j < 0) j = 0;

            curD = -curD;
        }
        return res;
    }

}
