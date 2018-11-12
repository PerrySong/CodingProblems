public class MatrixChainPorduct {
    /**
     * Given a sequence of matrices, find the most efficient way to multiply these matrices together.
     * The problem is not actually to perform the multiplications, but merely to decide in which order to
     * perform the multiplications.
     *
         Input: p[] = {40, 20, 30, 10, 30}
         Output: 26000
         There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
         Let the input 4 matrices be A, B, C and D.  The minimum number of
         multiplications are obtained by putting parenthesis in following way
         (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

         Input: p[] = {10, 20, 30, 40, 30}
         Output: 30000
         There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
         Let the input 4 matrices be A, B, C and D.  The minimum number of
         multiplications are obtained by putting parenthesis in following way
         ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30

         Input: p[] = {10, 20, 30}
         Output: 6000
         There are only two matrices of dimensions 10x20 and 20x30. So there
         is only one way to multiply the matrices, cost of which is 10*20*30
     */

    public int matrixChainOrder(int[] p) {
        if (p == null || p.length == 0) return 0;
        int n = p.length;

        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */

        // minPros holds the optimal solution for p (i, j)

        /* m[i,j] = Minimum number of scalar multiplications needed
               to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
                dimension of A[i] is p[i-1] x p[i] */
        int[][] minPros = new int[n][n];

        for (int l = 2; l <= n; l++) { // l is the length of the product chain
            for (int start = 1; start <= n - l; start++) {
                int end = start + l - 1;
                int min = Integer.MAX_VALUE;
                for (int split = start; split < end; split++) {
                    min = Math.min(minPros[start][split] + minPros[split + 1][end] + p[start - 1] * p[split] * p[end], min);
                }
                minPros[start][end] = min;
            }
        }
        return minPros[1][n - 1];
    }

    // Reference answer: https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
    static int MatrixChainOrder(int p[], int n)
    {
        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */
        int m[][] = new int[n][n];

        int i, j, k, L, q;

        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n-1];
    }

    public static void main(String[] args) {
        MatrixChainPorduct a = new MatrixChainPorduct();
        System.out.println(a.matrixChainOrder(new int[] {40, 20, 30, 10, 30} )); // 26000
        System.out.println(a.matrixChainOrder(new int[] {10, 20, 30, 40, 30} )); // 30000
        System.out.println(a.matrixChainOrder(new int[] {10, 20, 30} )); // 6000

        System.out.println(MatrixChainOrder(new int[] {40, 20, 30, 10, 30}, 5));
    }
}
