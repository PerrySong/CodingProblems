import java.util.Arrays;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        if(edges.length == 0) return null;
        int[] tree = new int[edges.length + 1];
        Arrays.fill(tree, -1);
        for(int i = 0; i < edges.length; i++) {
            if(find(edges[i][0], edges[i][1], tree)) {
                int[] res = new int[]{edges[i][0], edges[i][1]};
                return res;
            }
            union(edges[i][0], edges[i][1], tree);
        }
        return null;
    }

    private void union(int node1, int node2, int[] tree) {
        int r1 = findRoot(node1, tree);
        int r2 = findRoot(node2, tree);
        if(tree[r1] < tree[r2]) {
            tree[r2] = r1;
            tree[r1]--;
        } else {
            tree[r1] = r2;
            tree[r2]--;
        }

    }

    private int findRoot(int node, int[] tree) {
        while(tree[node] > -1)
            node = tree[node];
        return node;
    }



    private boolean find(int node1, int node2, int[] tree) {


        while(tree[node1] > -1)
            node1 = tree[node1];
        while(tree[node2] > -1)
            node2 = tree[node2];
        return node1 == node2;
    }

    public static void main(String[] args) {
        RedundantConnection a = new RedundantConnection();
        int[][] b = {{1,2},{1,3},{2,3}};
        System.out.println(a.findRedundantConnection(b)[0] + " " + a.findRedundantConnection(b)[1]);
    }
}
