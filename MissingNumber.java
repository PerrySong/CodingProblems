public class MissingNumber {
    /**
     * Bit manipulation solution
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
            System.out.println(" i = " + i);
            System.out.println(" num[i] = " + nums[i]);
            System.out.println("xor = " + xor);
        }

        return xor ^ i;
    }

    //Summation solution
    public static int missingNumber2(int[] nums) {
        int sum = 0;
        int truSum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            truSum += i;
        }
        return truSum + nums.length - sum;
    }

    public static void print(int[] array) {
        for(int elem: array) {
            System.out.print(elem + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 3};
        System.out.println(missingNumber2(nums));
        print(nums);

    }
}
