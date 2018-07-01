public class SearchForARange {
    /**
         Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

         Your algorithm's runtime complexity must be in the order of O(log n).

         If the target is not found in the array, return [-1, -1].

         Example 1:

         Input: nums = [5,7,7,8,8,10], target = 8
         Output: [3,4]
         Example 2:

         Input: nums = [5,7,7,8,8,10], target = 6
         Output: [-1,-1]
     */

    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        int[] res = new int[2];
        res[0] = index;
        res[1] = index;
        if(index == -1) return res;

        while(res[1] + 1 <= nums.length - 1 && nums[res[1] + 1] == target)
            res[1]++;
        while(res[0] - 1 >= 0 && nums[res[0] - 1] == target)
            res[0]--;

        return res;

    }

    private int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]) {
                end = mid;
            }
            if(target > nums[mid]) {
                start = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
