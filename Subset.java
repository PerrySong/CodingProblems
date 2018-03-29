import java.util.ArrayList;
import java.util.List;

/**
    Given a set of distinct integers, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    For example,
    If nums = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
 */

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> elem = new ArrayList<Integer>();
        helper(nums, res, elem, -1);
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, List<Integer> elem, int lindex) {
        res.add(new ArrayList(elem));
        for(int i = lindex + 1; i < nums.length; i++) {
            elem.add(nums[i]);
            helper(nums, res, elem, i);
            elem.remove(elem.size() - 1);
        }
    }
}
