import java.util.HashMap;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

     Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for(int num : nums) {
            if(map.get(num) == 0) {
                int left = num - 1;
                int right = num + 1;
                int sum = 1 + map.get(left) + map.get(right);
                map.put(num, sum);
                res = sum > res ? sum:res;
                //Extend the sum
                map.put(num - map.get(left), sum);
                map.put(num + map.get(right), sum);
            }
        }
        return res;
    }
}
