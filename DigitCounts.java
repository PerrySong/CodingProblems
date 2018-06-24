public class DigitCounts {
    public int digitCounts(int k, int n) {
        if (n < 0) return 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += childrenCount(i, k);
        }
        return res;
    }

    private int childrenCount(int parent, int child) {
        if(child == 0 && parent == 0)
            return 1;

        int res = 0;

        while(parent > 0) {
            res += parent % 10 == parent ? 1 : 0;
            parent /= 10;
        }
        return res;
    }
}
