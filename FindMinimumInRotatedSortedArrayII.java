public class FindMinimumInRotatedSortedArrayII {
    /**
     *
     *
     */

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[right] < nums[mid]) {
                left = mid + 1;
            } else if(nums[right] > nums[mid]) {
                right = mid ;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 10, 10};
        System.out.println(findMin(arr));
    }
}
