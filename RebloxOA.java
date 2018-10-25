import java.lang.reflect.Array;
import java.util.*;

public class RebloxOA {

    public static int orderCheck(List<Integer> height) {
        if (height == null) return 0;
        List<Integer> copy = new ArrayList<>(height);
        copy.remove(0);
        Collections.sort(copy);
        int res = 0;
        for (int i = 0; i < height.size() - 1; i++) {
            if (copy.get(i) != height.get(i) + 1) res++;
        }
        return res;
    }


    private static class Node implements Comparable<Node> {
        int location;
        private int dis;
        public Node( int to, int dis) {
            this.location = to;
            this.dis = dis;
        }
        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }

    public static List<String> classifyEdges(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        String[] res = new String[gFrom.size()];
        Arrays.fill(res, "NO");
        int[][] dis = new int[gNodes][gNodes];
        int[] prev = new int[gNodes];
        Arrays.fill(prev, -1);
        boolean[] visited = new boolean[gNodes];

        // Build graph
        for (int i = 0; i < gNodes; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < gFrom.size(); i++) {
            dis[gFrom.get(i) - 1][gTo.get(i) - 1] = gWeight.get(i);
        }

        PriorityQueue<Node> disQueue = new PriorityQueue<>();
        for (int i = 0; i < dis[0].length; i++) {
            disQueue.add(new Node(i, dis[0][i]));
        }

        int lastNode = 0;
        while (!disQueue.isEmpty()) {
            Node cur = disQueue.poll();
            if (visited[cur.location]) continue;
            prev[cur.location] = lastNode;
            if (cur.location == gNodes - 1) break;
            visited[cur.location] = true;
            for (int i = 0; i < gNodes; i++) {
                disQueue.add(new Node(i, dis[cur.location][i] + cur.dis));
            }
            lastNode = cur.location;
        }

        int i = gNodes - 1;
        while (i != 0) {
            res[i] = "YES";
            i = prev[i];
        }

        return Arrays.asList(res);
    }

    static int shorest = Integer.MAX_VALUE;
    public static List<String> classifyEdges2(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<String> res = new ArrayList<>();
        String[] tmp = new String[gFrom.size()];
        Arrays.fill(tmp, "NO");
        int[][] dis = new int[gNodes][gNodes];
        boolean[] visited = new boolean[gNodes];
        // Build graph
        for (int i = 0; i < gNodes; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < gFrom.size(); i++) {
            dis[gFrom.get(i) - 1][gTo.get(i) - 1] = gWeight.get(i);
        }

        dfs(dis, visited, res, tmp, 0, 0, gNodes);
        return res;
    }

    private static void dfs(int[][] dis, boolean[] visited, List<String> res, String[] tmp, int curPos, int curDis, int gNodes) {
        if (curDis < 0 || curDis > shorest || visited[curPos]) return;
        System.out.println(curPos);
        tmp[curPos] = "YES";
        visited[curPos] = true;
        if (curPos == gNodes - 1) {
            shorest = curDis;
            res.removeAll(res);
            for (String s : tmp) {
                res.add(s);
            }
            return;
        }
        for (int i = 0; i < gNodes; i++) {
            dfs(dis, visited, res, tmp, i, dis[curPos][i] + curDis, gNodes);
        }
        tmp[curPos] = "NO";
        visited[curPos] = false;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 4, 3, 2, 1);
        System.out.println(orderCheck(list));

        List<Integer> gFrom = Arrays.asList(1, 2, 1, 3, 1);
        List<Integer> gTo = Arrays.asList(2, 4, 3, 4, 4);
        List<Integer> weight = Arrays.asList(1, 1, 1, 2, 2);
//        System.out.println(classifyEdges(5, gFrom, gTo, weight));
        System.out.println(classifyEdges2(4, gFrom, gTo, weight));

    }



}
