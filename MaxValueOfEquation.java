import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxValueOfEquation {
    /**
     * You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi]
     * such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.
     *
     * Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.
     *
     * It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.
     * @param points
     * @param k
     * @return
     */
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> ((o2[1] - o2[0]) - (o1[1] - o1[0])));

        for (int[] point : points) {
            while (!pq.isEmpty() && point[0] - pq.peek()[0] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] maxPoint = pq.peek();
                int curValue = point[0] + point[1] + maxPoint[1] - maxPoint[0];
                res = Math.max(res, curValue);
            }
            pq.offer(point);
        }

        return res;
    }
}
