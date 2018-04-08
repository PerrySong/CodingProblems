import java.util.ArrayList;
import java.util.List;

public class SubsetII {

    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

         Note: The solution set must not contain duplicate subsets.

         For example,
         If nums = [1,2,2], a solution is:

         [
         [2],
         [1],
         [1,2,2],
         [2,2],
         [1,2],
         []
         ]
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> initSet = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, initSet, res, 0);
        return res;
    }

    public static void helper(int[] nums, List<Integer> set, List<List<Integer>> powerSet, int start) {
        if(!powerSet.contains(set))
            powerSet.add(new ArrayList(set));
        for(int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            helper(nums, set, powerSet, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
