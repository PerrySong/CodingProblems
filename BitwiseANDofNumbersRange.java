public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int res = n & m;
        res >>= (n - m);
        res <<= (n - m);
        return res;
    }

    public static void main(String[] args) {
        BitwiseANDofNumbersRange a = new BitwiseANDofNumbersRange();
        a.rangeBitwiseAnd(33, 1);
    }
}
