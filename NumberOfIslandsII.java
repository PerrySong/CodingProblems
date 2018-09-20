import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
    /**
         A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

         Example:

         Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
         Output: [1,1,2,3]
         Explanation:

         Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

         0 0 0
         0 0 0
         0 0 0
         Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

         1 0 0
         0 0 0   Number of islands = 1
         0 0 0
         Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

         1 1 0
         0 0 0   Number of islands = 1
         0 0 0
         Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

         1 1 0
         0 0 1   Number of islands = 2
         0 0 0
         Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

         1 1 0
         0 0 1   Number of islands = 3
         0 1 0
         Follow up:

         Can you do it in time complexity O(k log mn), where k is the length of the positions?
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0].length != 2) return res;
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        for (int[] pos : positions) {
            int i = pos[0];
            int j = pos[1];
            int root = i * n + j;
            if (roots[root] != -1) continue; // (visited before)
            roots[root] = -2;
            count++;
            int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            for (int[] dir : directions) { // Union 4 neighbors
                int neiI = i + dir[0];
                int neiJ = j + dir[1];
                if (neiI < 0 || neiI >= m || neiJ < 0 || neiJ >= n) continue; // If the neighbor is out of bound, continue.
                int neighbor = neiI * n + neiJ;
                if(roots[neighbor] != -1) { // If neighbor is a Island
                    if (union(roots, root, neighbor)) count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private boolean union(int[] roots, int i, int j) { // return true if union two branches, return false if the two branches are in the same root
        if (i < 0 || i >= roots.length || j < 0 || j >= roots.length) return false;
        while (roots[i] >= 0) i = roots[i];// Find the root for each branch
        while (roots[j] >= 0) j = roots[j];
        if (i == j) return false;
        if (roots[i] == roots[j]) {
            roots[i] = j;
            roots[j]--;
        } else if (roots[i] > roots[j]) {
            roots[i] = j;
        } else {
            roots[j] = i;
        }
        return true;
    }

    public static void main(String[] args) {
        NumberOfIslandsII a = new NumberOfIslandsII();

        System.out.println(a.numIslands2(8, 2, new int[][] {{7, 0}}));
        System.out.println(a.numIslands2(3, 3, new int[][] {{0,0},{0,1},{1,2},{2,1}}));
    }
}
