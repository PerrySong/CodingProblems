import java.util.*;

public class KnightDialer {
    private Map<Integer, List<Integer>> neighbors;
    Map<Integer, Map<Integer, Integer>> cache; // <number, <remain len, number of mutations>>

    public KnightDialer() {
        neighbors = new HashMap<>();
        cache = new HashMap<>();
        neighbors.put(1, Arrays.asList(6, 8));
        neighbors.put(2, Arrays.asList(7, 9));
        neighbors.put(3, Arrays.asList(4, 8));
        neighbors.put(4, Arrays.asList(3, 9, 0));
        neighbors.put(5, new ArrayList<>());
        neighbors.put(6, Arrays.asList(1, 7, 0));
        neighbors.put(7, Arrays.asList(2, 6));
        neighbors.put(8, Arrays.asList(1, 3));
        neighbors.put(9, Arrays.asList(2, 4));
        neighbors.put(0, Arrays.asList(4, 6));
    }

    public int dialer(int start, int len) {
        List<List<Integer>> res = new ArrayList<>();
        //< number, <len, combinations of numbers>>
        return dfs(start, len);
    }

    private int dfs(int start, int len) {
        if (len == 0) {
            return 0;
        }
        if (len == 1) return 1;
        if (cache.containsKey(start) && cache.get(start).containsKey(len)) {
            return cache.get(start).get(len);
        }
        int count = 0;
        for (int next : neighbors.get(start)) {
            count += dfs(next, len - 1);
        }
        if (!cache.containsKey(start)) {
            Map<Integer, Integer> lenToMutations = new HashMap<>();
            lenToMutations.put(len, count);
        } else {
            cache.get(start).put(len, count);
        }
        return count;
    }

    public static void main(String[] args) {
        KnightDialer a = new KnightDialer();
        System.out.println(a.dialer(6, 3));
    }
}
