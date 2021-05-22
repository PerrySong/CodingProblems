import java.util.ArrayList;
import java.util.List;

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{ newInterval };
        }

        // 1. newInterval merge with one of the interval
        // 2. newInterval merge with multiple of the intervals
        // 3. newInterval did not merge with any of the interval

        List<int[]> res = new ArrayList<>();
        int i = 0;
        boolean isAdded = false;

        while (i < intervals.length) {
            int[] curInterval = intervals[i];

            if (isOverLap(curInterval, newInterval)) {
                // merge the intervals
                newInterval = mergeIntervals(curInterval, newInterval);
            } else {
                if (newInterval[1] < curInterval[0] && !isAdded) {
                    res.add(newInterval);
                    res.add(curInterval);
                    isAdded = true;
                } else {
                    res.add(curInterval);
                }
            }
            i++;
        }
        if (!isAdded) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][2]);
    }


    public boolean isOverLap(int[] interval1, int[] interval2) {
        if (interval1[0] <= interval2[0]) {
            return interval1[1] >= interval2[0];
        }
        // interval1[0] > interval2[0]
        return interval2[1] >= interval1[0];
    }

    public int[] mergeIntervals(int[] interval1, int[] interval2) {
        return new int[] { Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1]) };
    }
}
