public class FindPeakElementLintcode {
    /**
         There is an integer array which has the following features:

         The numbers in adjacent positions are different.
         A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
         We define a position P is a peak if:

         A[P] > A[P-1] && A[P] > A[P+1]
         Find a peak element in this array. Return the index of the peak.

         It's guaranteed the array has at least one peak.
         The array may contain multiple peeks, find any of them.
         The array has at least 3 numbers in it.
     */

    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length == 0) return -1;
        int start = 0, end = A.length - 1;

        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (isPeak(A, mid)) return mid;

            if (A[mid] < A[end]) {
                start = mid;
            } else if (A[mid] < A[start]) {
                end = mid;
            } else {
                if(A[mid + 1] > A[mid])
                    start = mid;
                else
                    end = mid;
            }
        }

        if (isPeak(A, start)) return start;
        if (isPeak(A, end)) return end;
        return -1;
    }

    public boolean isPeak(int[] arr, int index) {
        if (arr == null || index <= 0 || index >= arr.length - 1) return false;
        if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) return true;
        return false;
    }
}
