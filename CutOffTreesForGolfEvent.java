import java.util.*;

public class CutOffTreesForGolfEvent {
    /**
     *
         You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

         0 represents the obstacle can't be reached.
         1 represents the ground can be walked through.
         The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.


         You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

         You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

         You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

         Example 1:

         Input:
         [
         [1,2,3],
         [0,0,4],
         [7,6,5]
         ]
         Output: 6


         Example 2:

         Input:
         [
         [1,2,3],
         [0,0,0],
         [7,6,5]
         ]
         Output: -1


         Example 3:

         Input:
         [
         [2,3,4],
         [0,0,5],
         [8,7,6]
         ]
         Output: 6
         Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
     */

    class Tree implements Comparable<Tree>{
        int[] pos;
        int height;
        public Tree(int[] pos, int height) {
            this.pos = pos;
            this.height = height;
        }
        public int compareTo(Tree t2) {
            return this.height - t2.height;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 || forest.get(0) == null | forest.get(0).size() == 0) return 0;
        int rows = forest.size();
        int cols = forest.get(0).size();
        int res = 0;
        List<Tree> treeList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (forest.get(i).get(j) == 0) continue;
                Tree curTree = new Tree(new int[]{i, j}, forest.get(i).get(j));
                treeList.add(curTree);
            }
        }
        Collections.sort(treeList);

        int[] pos = new int[]{0, 0};
        for (Tree tree: treeList) {
            int steps = bfs(forest, pos, tree.pos);
            if (steps == -1) return -1;
            pos = tree.pos;
            res += steps;
        }
        return res;
    }

    private int bfs(List<List<Integer>> forest, int[] p1, int[] p2) {
        int[][] ds = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visit = new boolean[forest.size()][forest.get(0).size()];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(p1);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                if (curPos[0] == p2[0] && curPos[1] == p2[1]) return res;
                for (int[] d: ds) {
                    int nexti = curPos[0] + d[0];
                    int nextj = curPos[1] + d[1];

                    if (nexti < 0 || nexti >= forest.size() || nextj < 0 || nextj >= forest.get(0).size() || forest.get(nexti).get(nextj) == 0 || visit[nexti][nextj]) continue;
                    visit[nexti][nextj] = true;
                    int[] nextPos = new int[]{nexti, nextj};
                    queue.offer(nextPos);
                }
            }
            res++;
        }

        return -1;
    }
}
