public class possibleMath {
    public static boolean possibleMath(int[] nums, int n) {
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, n, 0);
    }

    private static boolean dfs(int[] nums, boolean[] visited, int target, int level) {
        if (level == nums.length && target == 0) return true;
        if (level == nums.length) return false;

        for (int i = 0; i < nums.length; i++) {
            boolean res = false;
            if (visited[i] == false) {
                visited[i] = true;
                res = (dfs(nums, visited, target + nums[i], level + 1) |
                        dfs(nums, visited, target - nums[i], level + 1) |
                        dfs(nums, visited, target * nums[i], level + 1) |
                        dfs(nums, visited, target / nums[i], level + 1));
                visited[i] = false;
            }
            if (res) return res;

        }
        return false;
    }




    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(possibleMath(new int[] {1, 2, 3, 7, 11}, 1000));
    }
}
