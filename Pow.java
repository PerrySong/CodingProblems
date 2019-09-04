public class Pow {
    //Binary Search
    /**
         Implement pow(x, n), which calculates x raised to the power n (xn).

         Example 1:

         Input: 2.00000, 10
         Output: 1024.00000
         Example 2:

         Input: 2.10000, 3
         Output: 9.26100
         Example 3:

         Input: 2.00000, -2
         Output: 0.25000
         Explanation: 2-2 = 1/22 = 1/4 = 0.25
         Note:

         -100.0 < x < 100.0
         n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
     */

    //AmazonDebug 1:
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == 2) return x * x;
        if (n < 0) return 1 / x * myPow((1 / x), -(n + 1));
        if (n % 2 == 0) return myPow(myPow(x, n / 2), 2);
        else return x * myPow(myPow(x, (n - 1) / 2), 2);
    }

    //AmazonDebug 2:
    public double myPow2(double x, int n) {
        if (n >= 0) {
            return pow(x, n);
        } else {
            return 1.0 / pow(x, n);
        }
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    //AmazonDebug 3:
//    public double myPow3(double x, int n) {
//        if (n == 0) return x;
//    }
}
