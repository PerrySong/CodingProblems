public class CareerPrepProblems {
    /**
     *
     *
     *   Find the largest sum from the root to the bottom.
     *   From node [i, j], you can only go to node [i + 1, j], [i + 1, j + 1]
     *
     *   10
     *   22 31
     *   97 645 22
     *   81 99 0 271
     *
     */

    /**
     * Questions: can we change the triangle's values?
     *
     * @param triangle
     * @return
     */
    public static int largestSum(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) return 0;
        // We store the current maximum sum from the root node to the current node.

        // Initialization: the left most branch and right most branch can only have one path, so the max sum is fixed
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
        }

        // Current largest sum should be the max sum of parents' + current node value.
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
            }
        }

        // Iterate the last level and return the largest sum
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < triangle[triangle.length - 1].length; j++) {
            res = Math.max(res, triangle[triangle.length - 1][j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] triangle = new int[][] {{10}, {22, 31}, {97, 645, 22}, {81, 99, 0, 217}};
        System.out.println(largestSum(triangle));
    }
}
