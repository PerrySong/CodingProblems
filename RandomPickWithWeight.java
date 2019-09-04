public class RandomPickWithWeight {


    /**
        Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

        Note:

        1 <= w.length <= 10000
        1 <= w[i] <= 10^5
        pickIndex will be called at most 10000 times.
        Example 1:

        Input:
        ["AmazonDebug","pickIndex"]
        [[[1]],[]]
        Output: [null,0]
        Example 2:

        Input:
        ["AmazonDebug","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
        [[[1,3]],[],[],[],[],[]]
        Output: [null,0,1,1,1,0]
        Explanation of Input Syntax:

        The input is two lists: the subroutines called and their arguments. AmazonDebug's constructor has one argument, the array w. pickIndex has no arguments.
        Arguments are always wrapped with a list, even if there aren't any.
     */

    private double[] p;

    public RandomPickWithWeight(int[] w) {

        p = new double[w.length];

        long sum = 0;
        for (int num : w) {
            sum += num;
        }
        for (int i = 0; i < p.length; i++) {
            p[i] = (i == 0 ? 0 : p[i - 1]) + (double)w[i] / sum;
        }
        System.out.println(p);
    }

    public int pickIndex() {
        double random = Math.random();
        int index = findIndex(random);
        return index;
    }

    private int findIndex(double target) {
        int left = 0, right = p.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (p[mid] == target) {
                return mid;
            } else if (p[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (p[right] >= target) return right;
        return left;
    }

    public static void main(String[] args) {
        RandomPickWithWeight a = new RandomPickWithWeight(new int[] {3, 4, 1, 17});
        a.pickIndex();

    }
}
