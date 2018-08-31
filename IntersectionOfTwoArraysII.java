import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    /**
         Given two arrays, write a function to compute their intersection.

         Example 1:

         Input: nums1 = [1,2,2,1], nums2 = [2,2]
         Output: [2,2]
         Example 2:

         Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
         Output: [4,9]
         Note:

         Each element in the result should appear as many times as it shows in both arrays.
         The result can be in any order.
         Follow up:

         What if the given array is already sorted? How would you optimize your algorithm?
            A: Use Two pointer solution. O(n + m)
         What if nums1's size is small compared to nums2's size? Which algorithm is better?
            A: Binary search will be better: O(nlg(m))
         What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

     */
    /**
     * T(n) = lg(n)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        ArrayList<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> num1ToFreq = new HashMap<>();

        for (int num : nums1) {
            num1ToFreq.put(num, num1ToFreq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (!num1ToFreq.containsKey(num) || num1ToFreq.get(num) == 0) continue;
            intersection.add(num);
            num1ToFreq.put(num, num1ToFreq.get(num) - 1);
        }

        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersection.get(i);
        }
        return res;
    }
}
