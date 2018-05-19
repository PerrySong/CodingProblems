import java.util.List;

public class Triangle {
    /**
     * Back track solution:
     O(2^n) Too slow


    int sum = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        findMin(triangle, 0, 0, 0);
        return sum;
    }

    private void findMin(List<List<Integer>> triangle, int row, int index, int curSum) {
        if(row == triangle.size()) {
            sum = Math.min(curSum, sum);
            return;
        }
        for(int i = index; i <= index + 1; i++) {
            findMin(triangle, row + 1, i, curSum + triangle.get(row).get(index));
        }
    }
     */

    /**
     * Dp solution:
     * Time complexity: O(n^2)
     * Space: O(n)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[] lookup = new int[n];

        for(int i = 0; i < n; i++) {
            lookup[i] = triangle.get(n - 1).get(i);
        }

        for(int i = n - 2; i >= 0 ; i--) {
            for(int j = 0; j <= i; j++) {
                lookup[j] = Math.min(lookup[j], lookup[j + 1]) + triangle.get(i).get(j);
            }
        }
        return lookup[0];
    }


}
