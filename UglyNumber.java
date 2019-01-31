import java.util.HashSet;
import java.util.Set;

public class UglyNumber {

    public static int nUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 2;
        nums[1] = 3;
        nums[2] = 4;
        nums[3] = 5;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for (int i = 4; i < n; i++) {
            while (nums[i2] * 2 <= nums[i])
                i2++;
            while (nums[i3] * 3 <= nums[i])
                i3++;
            while (nums[i5] * 5 <= nums[i])
                i5++;

            if (nums[i2] * 2 < nums[i3] * 3 && nums[i2] < nums[i5]) {
                nums[i] = nums[i2] * 2;
                i2++;
            } else if (nums[i3] < nums[i5]) {
                nums[i] = nums[i3] * 3;
                i3++;
            } else {
                nums[i] = nums[i5] * 5;
                i5++;
            }
        }

        return nums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nUglyNumber(10));
    }
}
