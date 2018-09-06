public class NextPermutation {
    /**
         Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

         If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

         The replacement must be in-place and use only constant extra memory.

         Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

         1,2,3 → 1,3,2
         3,2,1 → 1,2,3
         1,1,5 → 1,5,1

     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int first = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                first = i;
                break;
            }
        }

        System.out.println(first);
        if (first == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }


        for (int second = nums.length - 1; second >= 0; second--) {
            if (nums[second] > nums[first]) {
                System.out.println(second);
                swap(nums, first, second);

                for (int i : nums)
                    System.out.print(i + " @");

                reverse(nums, first + 1, nums.length - 1);
                break;
            }
        }


    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation a = new NextPermutation();
        int[] arr = new int[] {2, 3, 1};
        a.nextPermutation(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
