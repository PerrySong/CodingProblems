import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    /**
         You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

         Each 0 marks an empty land which you can pass by freely.
         Each 1 marks a building which you cannot pass through.
         Each 2 marks an obstacle which you cannot pass through.
         Example:

         Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

         1 - 0 - 2 - 0 - 1
         |   |   |   |   |
         0 - 0 - 0 - 0 - 0
         |   |   |   |   |
         0 - 0 - 1 - 0 - 0

         Output: 7

         Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
         the point (1,2) is an ideal empty land to build a house, as the total
         travel distance of 3+3+1=7 is minimal. So return 7.
         Note:
         There will be at least one building. If it is not possible to build such house according to the above rules, return -1
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int res = Integer.MAX_VALUE;
        ArrayList<int[]> housePos = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) housePos.add(new int[] {i, j});
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) continue;
                int curSum = 0;
                boolean hasPath = true;
                for (int[] pos : housePos) {

                    int dis = distance(grid, new int[] {i, j}, pos);
                    if (dis == -1) {
                        hasPath = false;
                        break;
                    }
                    curSum += dis;
                }
                if (!hasPath) continue;
                res = Math.min(curSum, res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    //Use bfs find the shorest path
    private int distance(int[][] grid, int[] pos1, int[] pos2) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(pos1);
        int res = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int[] curPos = queue.poll();

                for (int[] next : nextMove(grid, curPos)) {
                    if (next[0] == pos2[0] && next[1] == pos2[1]) {
                        return res + 1;
                    }
                    if (visited[next[0]][next[1]] || grid[next[0]][next[1]] != 0) continue;
                    queue.offer(next);
                    visited[next[0]][next[1]] = true;
                }
            }
            res++;
        }
        return -1;
    }

    // Return all the possible next moves
    private List<int[]> nextMove(int[][] grid, int[] curPos) {
        List<int[]> res = new ArrayList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int row = dx[i] + curPos[0], col = dy[i] + curPos[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                if (grid[row][col] == 0 || grid[row][col] == 1) {
                    res.add(new int[] {row, col});
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings a = new ShortestDistanceFromAllBuildings();
        System.out.println(a.shortestDistance(new int[][] {{1, 1}, {1, 0}}));
        System.out.println(a.shortestDistance(new int[][] {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}}));

    }
}
