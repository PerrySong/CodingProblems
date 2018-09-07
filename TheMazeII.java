import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {
    /**
         There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

         Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

         The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

         Example 1

         Input 1: a maze represented by a 2D array

         0 0 1 0 0
         0 0 0 0 0
         0 0 0 1 0
         1 1 0 1 1
         0 0 0 0 0

         Input 2: start coordinate (rowStart, colStart) = (0, 4)
         Input 3: destination coordinate (rowDest, colDest) = (4, 4)

         Output: 12
         Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
         The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

         Example 2

         Input 1: a maze represented by a 2D array

         0 0 1 0 0
         0 0 0 0 0
         0 0 0 1 0
         1 1 0 1 1
         0 0 0 0 0

         Input 2: start coordinate (rowStart, colStart) = (0, 4)
         Input 3: destination coordinate (rowDest, colDest) = (3, 2)

         Output: -1
         Explanation: There is no way for the ball to stop at the destination.

         Note:
         There is only one ball and one destination in the maze.
         Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
         The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
         The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
     */

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0 || start == null || destination == null) return -1;

        int distance = Integer.MAX_VALUE;
        // posQueue records postion and disQueue records current distance from start
        Queue<int[]> posQueue = new LinkedList<>();
        Queue<Integer> disQueue = new LinkedList<>();
        posQueue.offer(start);
        disQueue.offer(0);

        //visitedDis holds the shorested distance to point
        int[][] visitedDis = new int[maze.length][maze[0].length];
        for (int i = 0; i < visitedDis.length; i++) {
            Arrays.fill(visitedDis[i], Integer.MAX_VALUE);
        }
        visitedDis[start[0]][start[1]] = 0;

        while (!posQueue.isEmpty()) {
            // Get the current position and distance
            int[] curPos = posQueue.poll();
            int curDis = disQueue.poll();

            // Roll the ball to 4 directions
            int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] direction : directions) {

                int[] stop = rollBall(maze, curPos, direction);
                // System.out.println(stop[0] + " " + stop[1]);
                int totalDis = Math.abs(stop[0] - curPos[0]) + Math.abs(stop[1] - curPos[1]) + curDis;

                if (stop[0] == destination[0] && stop[1] == destination[1]) {
                    distance = Math.min(totalDis, distance);

                } else if (visitedDis[stop[0]][stop[1]] > totalDis) {
                    posQueue.offer(stop);
                    disQueue.offer(totalDis);
                    visitedDis[stop[0]][stop[1]] = totalDis;
                }

            }

        }

        if (distance == Integer.MAX_VALUE) return -1;
        return distance;
    }

    private int[] rollBall(int[][] maze, int[] start, int[] direction) {
        int ver = direction[0];
        int her = direction[1];
        int curRow = start[0];
        int curCol = start[1];
        while (
                curRow + ver < maze.length &&
                        curRow + ver >= 0 &&
                        curCol + her < maze[0].length &&
                        curCol + her >= 0 &&
                        maze[curRow + ver][curCol + her] != 1
                ) {
            curRow += ver;
            curCol += her;
            // System.out.println(curRow + " " + curCol);
        }
        return new int[] {curRow, curCol};
    }
    // [0,0,1,0,0],
    // [0,0,0,0,0],
    // [0,0,0,1,0],
    // [1,1,0,1,1],
    // [0,0,0,0,0]
}
