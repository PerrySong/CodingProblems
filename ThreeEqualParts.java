public class ThreeEqualParts {

    /**
     * Leetcode weekly contest
     * @param A
     * @return
     */
    public int[] threeEqualParts(int[] A) {
        if (A == null || A.length < 3) return new int[] {-1, -1, -1};
        int[] vals = new int[A.length + 1];
        int cur = 1;
        for (int i = 0; i < A.length; i++) {
            vals[i + 1] = vals[i] + A[i] * cur;
            cur *= 2;
        }

        int p1 = 0, p2 = A.length - 1;

        while (p1 < p2) {
            int lVal = biValue(vals, 0, p1), mVal = biValue(vals, p1, p2 - 1), rVal = biValue(vals, p2, A.length - 1);
            if (lVal == rVal && lVal == mVal) return new int[] {p1, p2};
            else if (lVal < rVal && rVal < mVal) p1++;
            else if (rVal < lVal && lVal < mVal) p2--;
            else if (rVal < mVal && lVal < mVal) {
                p1++;
                p2--;
            }
            else return new int[] {-1, -1};
        }
        
        return new int[] {-1, -1};
    }

    private int biValue(int[] arr, int start, int end) {
        return arr[end] / (int)Math.pow(2, start);
    }

    public static void main(String[] args) {
        ThreeEqualParts a = new ThreeEqualParts();
        System.out.println(a.threeEqualParts(new int[] {1,0,1,0,1}));
    }
}
