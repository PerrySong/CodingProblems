import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

    /**
     *
     *  Given a collection of candidate numbers (candidates) and a target number (target),
     *  find all unique combinations in candidates where the candidate numbers sums to target.

        Each number in candidates may only be used once in the combination.

        Note:

        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.

        Time: O(2^n)
        space: O(n)
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(candidates, target, 0, new ArrayList<>(), res, 0);
        return res;
    }

    public void helper(int[] candidates, int target, int cur, List<Integer> list, List<List<Integer>> res, int sum) {
        if(sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        if(sum < target) {
            for(int i = cur; i < candidates.length; i++) {
                if(i != cur && candidates[i] == candidates[i - 1]) continue;
                //When it goes to next level, it could have duplicates, but not in the same level!!
                sum += candidates[i];
                list.add(candidates[i]);

                helper(candidates, target, i + 1, list, res, sum);

                list.remove(list.size() - 1);
                sum -= candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII a = new CombinationSumII();
        int[] b = {10,1,2,7,6,1,5};
        System.out.println(a.combinationSum2(b,8));
    }
}
