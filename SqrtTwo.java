public class SqrtTwo {
    /**
         Description
         Implement int sqrt(int x).

         Compute and return the square root of x.
     */

    public int sqrt(int x) {
        // write your code here
        if (x < 0) return -1;

        long end = x;
        long start = 0;

        while (start < end - 1) {
            long mid = start + (end - start) / 2;

            if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }


        if (end * end <= x) return (int)end;
        if (start * start <= x) return (int)start;

        return -1;

    }
}
