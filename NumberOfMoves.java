import java.util.LinkedList;
import java.util.Queue;

public class NumberOfMoves {
    public static int minMoves(int n, int startX, int startY, int endX, int endY) {
        //BFS
        boolean[][] visited = new boolean[n][n];
        int[][] moves = new int[][] {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        int[] start = new int[]{startX, startY};
        int count = 0; // count the steps

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) { // Only poll the elements from this level
                int[] curPos = queue.poll();
                if (curPos[0] == endX && curPos[1] == endY)
                    return count;
                for (int[] move : moves) {
                    int nextX = curPos[0] + move[0];
                    int nextY = curPos[1] + move[1];
                    if (nextX >= 0 && nextX < n &&
                            nextY >= 0 && nextY < n &&
                            !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }
            count++;
        }
        return -1; // Never reach the end
    }
}
