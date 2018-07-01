public class DivideTwoIntegers {
    /**

         Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

         Return the quotient after dividing dividend by divisor.

         The integer division should truncate toward zero.

         Example 1:

         Input: dividend = 10, divisor = 3
         Output: 3
         Example 2:

         Input: dividend = 7, divisor = -3
         Output: -2
         Note:

         Both dividend and divisor will be 32-bit signed integers.
         The divisor will never be 0.
         Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
         [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
     */

    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        long res = divideHelper(ldividend, ldivisor);
        if(sign == -1) {
            if(-res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int)-res;
        } else {
            if(res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)res;
        }
    }

    private static long divideHelper(long dividend, long divisor) {
        if(dividend < divisor) return 0;
        long multiple = 1;
        long sum = divisor;
        while(sum + sum <= dividend) {
            sum = sum + sum;
            multiple = multiple + multiple;
        }
        return multiple + divideHelper(dividend - sum, divisor);
    }

    public static void main(String[] args) {
        divide(-2147483648,
                -1);
    }
}
