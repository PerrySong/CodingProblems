import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
         Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

         Note:

         The solution set must not contain duplicate triplets.

         Example:

         Given array nums = [-1, 0, 1, 2, -1, -4],

         A solution set is:
         [
         [-1, 0, 1],
         [-1, -1, 2]
         ]
     */

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {

                int curSum = nums[i] + nums[j] + nums[k];

                if(curSum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);

                    res.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
                if(curSum > 0)
                    k--;
                if(curSum < 0)
                    j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum a = new ThreeSum();
        int[] b = {-1,0,1,2,-1,-4};
        a.threeSum(b);
    }
}
