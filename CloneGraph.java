import java.util.*;

public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        // Copy node and its value
        Map<UndirectedGraphNode, UndirectedGraphNode> copyMap = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (cur != null)
                copyMap.put(cur, new UndirectedGraphNode(cur.label));

            // no duplicate
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (copyMap.containsKey(neighbor)) continue;
                queue.offer(neighbor);
            }
        }

        // copy the structure
        for (UndirectedGraphNode cur : copyMap.keySet()) {
            UndirectedGraphNode copyNode = copyMap.get(cur);

            for (UndirectedGraphNode neighbor : cur.neighbors) {
                copyNode.neighbors.add(copyMap.get(neighbor));
            }
        }

        return copyMap.get(node);
    }
}
