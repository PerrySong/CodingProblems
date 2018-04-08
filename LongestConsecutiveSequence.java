import java.util.HashMap;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

     Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence {
    /** Note: If there is no such key in the HashMap  */
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for(int num : nums) {
            if(!map.containsKey(num)) {
                int left = map.containsKey(num - 1)? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1)? map.get(num + 1) : 0;
                int sum = 1 + left + right;
                map.put(num, sum);
                res = sum > res ? sum:res;
                //Extend the sum
                map.put(num -  left, sum);
                map.put(num + right, sum);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }
}
