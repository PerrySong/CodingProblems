public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 1), robHelper(nums, 1, nums.length));
    }

    private int robHelper(int[] nums, int start, int end) {
        int include = 0;
        int exclude = 0;
        for(int i = start; i < end; i++) {
            int lastInclude = include;
            include = exclude + nums[i];
            exclude = Math.max(lastInclude, exclude);
        }
        return Math.max(include, exclude);
    }
}
