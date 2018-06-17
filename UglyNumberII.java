public class UglyNumberII {
    /**
         Write a program to find the n-th ugly number.

         Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

         Example:

         Input: n = 10
         Output: 12
         Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
         Note:

         1 is typically treated as an ugly number.

     */
    public int nthUglyNumber(int n) {

        int[] ugly = new int[n];
        ugly[0] = 1;

        int i2 = 1, i3 = 1, i5 = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int i = 1;
        while(i < n) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            if(factor2 == min) {
                if(ugly[i - 1] != factor2)
                    ugly[i++] = factor2;
                factor2 = 2 * ugly[i2++];

            } else if(factor3 == min) {

                if(ugly[i - 1] != factor3)
                    ugly[i++] = factor3;
                factor3 = 3 * ugly[i3++];

            } else if(factor5 == min) {
                if(ugly[i - 1] != factor5)
                    ugly[i++] = factor5;
                factor5 = 5 * ugly[i5++];

            }
        }
        return ugly[n - 1];

    }
}
