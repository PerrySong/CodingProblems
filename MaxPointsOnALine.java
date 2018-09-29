import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    /**
         Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

         Example 1:

         Input: [[1,1],[2,2],[3,3]]
         Output: 3
         Explanation:
         ^
         |
         |        o
         |     o
         |  o
         +------------->
         0  1  2  3  4
         Example 2:

         Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
         Output: 4
         Explanation:
         ^
         |
         |  o
         |     o        o
         |        o
         |  o        o
         +------------------->
         0  1  2  3  4  5  6
     */

    /**
     * Definition for a point.
     */

     static class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
     }


    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        int size = points.length;
        int max = 1;
        for (int i = 0; i < size; i++) {
            Map<Double, Integer> slopeToFreq = new HashMap<>();
            int same = 0;
            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                if (points[i].x - points[j].x == 0 && points[i].y - points[j].y == 0) same++;
                else if (points[i].y - points[j].y == 0) {
                    slopeToFreq.put(Double.MAX_VALUE, slopeToFreq.getOrDefault(Double.MAX_VALUE, 0) + 1);
                } else {
                    double slope = (double) (points[i].x - points[j].x) / (points[i].y - points[j].y);
                    slopeToFreq.put(slope, slopeToFreq.getOrDefault(slope, 0) + 1);
                }
            }
            for (Double key : slopeToFreq.keySet()) {
                max = Math.max(max, slopeToFreq.get(key) + 1 + same);
            }
            // if there are all the same
            max = Math.max(same + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
         MaxPointsOnALine a = new MaxPointsOnALine();
         Point[] arr = new Point[] {new Point(1, 1), new Point(1, 1), new Point(1, 1), new Point(1, 1)};
        System.out.println(a.maxPoints(arr));
    }
}
