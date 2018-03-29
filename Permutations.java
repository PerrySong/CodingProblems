import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Given a collection of distinct numbers, return all possible permutations.
//
//        For example,
//        [1,2,3] have the following permutations:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        permute(nums, new ArrayList<Integer>(), res);
        return res;
    }

    public static void permute(int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if(cur.size() == nums.length) {
            System.out.println(cur);
            res.add(new ArrayList<Integer>(cur));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(cur.contains(nums[i])) continue;
                cur.add(nums[i]);
                permute(nums, cur, res);
                cur.remove(cur.size() - 1);
            }
            System.out.println(666);
        }

    }

    /**
     * This could handle duplicate elements
     * @param nums
     * @return
     */
    public static List<List<Integer>>  permuteII(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        permuteII(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }

    public static List<List<Integer>> permuteII(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList(temp));
        } else {
            int pre = nums[0] - 1; //Set a number which is not in this list
            for(int i = 0; i < nums.length; i++) {
                if(used[i] || pre == nums[i]) continue;
                temp.add(nums[i]);
                used[i] = true;
                pre = nums[i];
                permuteII(nums, used, temp, res);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
//        permute(num);
        System.out.println(permute(num));
        ArrayList<Integer> a = new ArrayList<>();

        int[] num2 = {1, 1, 2};
        System.out.println(permuteII(num2));

    }
}
