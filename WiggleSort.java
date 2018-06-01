public class WiggleSort {

    /**
     *

         Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

         Example:

         Input: nums = [3,5,2,1,6,4]
         Output: One possible answer is [3,5,1,6,2,4]
     */
    public void wiggleSort(int[] nums) {
        boolean asending = true;
        for(int i = 0; i < nums.length - 1; i++) {
            if(asending) {
                if(nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if(nums[i] < nums[i + 1])
                    swap(nums, i, i + 1);
            }
            asending = !asending;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
