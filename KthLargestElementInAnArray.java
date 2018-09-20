public class KthLargestElementInAnArray {
    /**
         Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

         Example 1:

         Input: [3,2,1,5,6,4] and k = 2
         Output: 5
         Example 2:

         Input: [3,2,3,1,2,4,5,5,6] and k = 4
         Output: 4
         Note:
         You may assume k is always valid, 1 ≤ k ≤ array's length.
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k < 0 || k > nums.length - 1) return Integer.MIN_VALUE;
        int low = 0, high = nums.length - 1;
        int pivot = partition(nums, low, high);
        int index = nums.length - k;
        while (pivot != index) {
            if (pivot > index) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
            pivot = partition(nums, low, high);
        }
        return nums[index];
    }

    private int partition(int[] nums, int low, int high) {
        int pivotNum = nums[high];
        int i = low, j = high - 1;
        while (i <= j) {
            while (j >= i && nums[j] >= pivotNum) j--;
            while (i <= j && nums[i] < pivotNum) i++;
            if (i < j)
                swap(nums, i, j);
        }
        swap(nums, i, high);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray a = new KthLargestElementInAnArray();
        System.out.println(a.findKthLargest(new int[] {1}, 1));
    }
}
