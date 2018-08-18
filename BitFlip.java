public class BitFlip {
    
    public int bitFlip(int[] array, int length) {
        int left = 0, right = length - 1;
        int res = 0;
        while (left < right) {
            while (array[left] == 1) {
                left++;
            }

            while (array[right] == 1) {
                right--;
            }
            int cf = countFlip(array, left, right)
            res = res > cf ? res : cf;
            while (array[left] == 0) {
                left++;
            }
            while (array[right] == 0) {
                right--;
            }
        }

        return res;
    }

    private int countFlip(int[] array, int left, int right) {
        int count = 0;
        for (int i = 0; i < left; i++) {
            if (array[i] == 1) count++;
        }
        for (int i = left; i <= right; i++) {
            if (array[i] == 0) count++;
        }
        for (int i = right + 1; i < array.length; i++) {
            if (array[i] == 1) count++;
        }
        return count;
    }
}
