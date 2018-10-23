import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KnightDialer {

    private final static int[][] DIRECTIONS  = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};



    public int dfsDialer(int i, int j) {
        boolean[][] visited = new boolean[4][3];
        return dfs(new int[] {i, j}, visited);
    }
    public int dfs(int[] start, boolean[][] visited) {
        if ((start[0] < 0 || start[0] > 3 || start[1] < 0 || start[1] > 2) || // Check the start is inside of the board
                (start[0] == 3 && (start[1] == 0 || start[1] == 2)) ||
                visited[start[0]][start[1]]) {
            return 0;
        }
        int res = 1;
        visited[start[0]][start[1]] = true;
        for (int[] dir : DIRECTIONS) {
            res += dfs(new int[] {start[0] + dir[0], start[1] + dir[1]}, visited);
        }
        return res;
    }

    public int bfsDialer(int i, int j) {
        boolean[][] visited = new boolean[4][3];
        Queue<int[]> queue = new LinkedList<>();
        int[] start = new int[] {i, j};
        queue.offer(start);
        int count = 0;
        while (!queue.isEmpty()) {
            start = queue.poll();
            if ((start[0] < 0 || start[0] > 3 || start[1] < 0 || start[1] > 2) || // Check the start is inside of the board
                    (start[0] == 3 && (start[1] == 0 || start[1] == 2)) ||
                    visited[start[0]][start[1]]) {
                continue;
            }
            for (int[] dir : DIRECTIONS) {
                queue.offer(new int[] {start[0] + dir[0], start[1] + dir[1]});
            }
            visited[start[0]][start[1]] = true;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        KnightDialer a = new KnightDialer();
        System.out.println(a.dfsDialer(3, 1));
        System.out.println(a.dfsDialer(10, 10));
        System.out.println(a.dfsDialer(1, 0));
        System.out.println(a.dfsDialer(3, 0));

        System.out.println(a.bfsDialer(3, 1));
        System.out.println(a.bfsDialer(10, 10));
        System.out.println(a.bfsDialer(1, 0));
        System.out.println(a.bfsDialer(3, 0));
        System.out.println(a.bfsDialer(2, 1));
    }
}
