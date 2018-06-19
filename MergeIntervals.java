import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    /**
         Given a collection of intervals, merge all overlapping intervals.

         Example 1:

         Input: [[1,3],[2,6],[8,10],[15,18]]
         Output: [[1,6],[8,10],[15,18]]
         Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
         Example 2:

         Input: [[1,4],[4,5]]
         Output: [[1,5]]
         Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
     */

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return new LinkedList<>();

        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2){
                return i1.start - (i2.start);
            }
        });
        // Sort by ascending starting point using an anonymous Comparator
        // intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> res = new LinkedList<>();
        for(int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            while(i < intervals.size() - 1 && intervals.get(i + 1).start <= end) {
                end = Math.max(end, intervals.get(++i).end);
            }
            Interval newInterval = new Interval(start, end);
            res.add(newInterval);
        }
        return res;
    }
}
