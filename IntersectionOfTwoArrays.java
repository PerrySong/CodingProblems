import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays {
    /**
         Given two arrays, write a function to compute their intersection.

         Example 1:

         Input: nums1 = [1,2,2,1], nums2 = [2,2]
         Output: [2]
         Example 2:

         Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
         Output: [9,4]
         Note:

         Each element in the result must be unique.
         The result can be in any order.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }

        for (int num: nums2) {
            if (set1.contains(num))
                intersect.add(num);
        }

        int[] res = new int[intersect.size()];
        Iterator<Integer> iter = intersect.iterator();
        for (int i = 0; i < res.length; i++) {
            res[i] = iter.next();
        }
        return res;
    }
}
