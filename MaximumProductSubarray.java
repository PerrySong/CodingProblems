public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(tmp * nums[i], Math.min(min * nums[i], nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray a = new MaximumProductSubarray();
        System.out.println(a.maxProduct(new int[]{2,-5,-2,-4,3}));
    }
}
