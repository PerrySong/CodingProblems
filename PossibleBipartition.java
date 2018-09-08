import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleBipartition {

    /**
         Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

         Each person may dislike some other people, and they should not go into the same group.

         Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

         Return true if and only if it is possible to split everyone into two groups in this way.



         Example 1:

         Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
         Output: true
         Explanation: group1 [1,4], group2 [2,3]
         Example 2:

         Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
         Output: false
         Example 3:

         Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
         Output: false


         Note:

         1 <= N <= 2000
         0 <= dislikes.length <= 10000
         1 <= dislikes[i][j] <= N
         dislikes[i][0] < dislikes[i][1]
         There does not exist i != j for which dislikes[i] == dislikes[j].
     */

    /**
     * T(n) = O(2 ^ n)
     * Space = O(n)
     * @param N
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes == null) return false;
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

        //Build graph
        for (int[] pair : dislikes) {
            int p1 = pair[0];
            int p2 = pair[1];

            if (!graph.containsKey(p1)) {
                graph.put(p1, new HashSet<Integer>());
            }
            if (!graph.containsKey(p2)) {
                graph.put(p2, new HashSet<Integer>());
            }

            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        //Stores groups infomation in group
        int[] group = new int[N]; // group: -1, 1, no visited: 0
        for (int i = 0; i < N; i++) {
            int person = i + 1;
            if (!graph.containsKey(person)) continue;
            if (group[i] != 0)
                setGroup(graph, group, i, group[i]);
            else if (!setGroup(graph, group, i, -1) && !setGroup(graph, group, i, 1)) return false;
        }
        return true;
    }

    private boolean setGroup(Map<Integer, Set<Integer>> graph, int[] group, int i, int groupNum) {
        if (group[i] != 0 && group[i] != groupNum) return false;
        if (group[i] == groupNum) return true;
        int originNum = group[i];
        group[i] = groupNum;

        Set<Integer> dislikes = graph.get(i + 1);

        for (int dislike : dislikes) {
            if (!setGroup(graph, group, dislike - 1, -groupNum)) {
                // If not working, do not change the person's group
                group[i] = originNum;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition a = new PossibleBipartition();
        System.out.println(a.possibleBipartition(1, new int[][] {}));
    }
}
