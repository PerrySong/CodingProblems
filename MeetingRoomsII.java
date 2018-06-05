import java.util.Arrays;

public class MeetingRoomsII {
    /**
         Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

         Example 1:

         Input: [[0, 30],[5, 10],[15, 20]]
         Output: 2
         Example 2:

         Input: [[7,10],[2,4]]
         Output: 1
     */



    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        int si = 0, ei = 0, rooms = 0, res = 0;
        Arrays.sort(starts);
        Arrays.sort(ends);
        while (si < starts.length) {
            if (starts[si] <= ends[ei]) {
                rooms++;
                si++;
                res = Math.max(res, rooms);
            } else {
                ei++;
                rooms--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MeetingRoomsII a = new MeetingRoomsII();
        Interval[] b = new Interval[3];

        b[0] = new Interval(0, 30);
        b[1] = new Interval(5, 10);
        b[2] = new Interval(15, 20);
        a.minMeetingRooms(b);
    }
}
