public class FirstMissingPositive {
    /**
     *
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int i = 0;
        while (i < nums.length) {
            System.out.println("what ? :" + nums.length);
            if (nums[i] <= 0 || nums[i] > i + 1) i++;
            else if (nums[nums[i] - 1] != nums[i]) swap(nums, nums[i] - 1, i);
            else i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        FirstMissingPositive a = new FirstMissingPositive();
        System.out.println(a.firstMissingPositive(new int[] {3,4,-1,1}));
    }
}
