public class TrappingRainWater {
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while(left <= right) {
            if(leftMax < rightMax) {
                System.out.println("left -> " + left);
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            } else {
                System.out.println("right -> " + right);
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;

            }
            System.out.println("res = " + res);

        }
        System.out.println("left = " + left + " right = " + right);
        return res;
    }

    public static void main(String[] args) {
        int[] trap = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(trap));
        long i;
        for(i = 0; (i * i + 4)% 11 != 0; i++);
        System.out.println("i " + i);

    }
}
