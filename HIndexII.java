import java.util.Arrays;

public class HIndexII {
    /**
     *
     * Given an array of citations in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

         According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than hcitations each."

         Example:

         Input: citations = [0,1,3,5,6]
         Output: 3
         Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
         received 0, 1, 3, 5, 6 citations respectively.
         Since the researcher has 3 papers with at least 3 citations each and the remaining
         two with no more than 3 citations each, his h-index is 3.
         Note: If there are several possible values for h, the maximum one is taken as the h-index.


     */
    /**
     * Brute force:
     * Time: O(n)
     * Space: O(1)
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int n = citations.length;
        int h = n;

        if(citations[0] >= n) return n;
        for(int i = 1; i < n; i++) {
            h--;
            if(citations[i] >= h && citations[i - 1] < h) return h;
        }
        return 0;
    }

    /**
     * Binary Search Solution:
     * Time: O(lg n)
     * Space: O(1)
     */
    public int hIndexBS(int[] citations) {
        if(citations.length == 0) return 0;
        int start = 0;
        int end = citations.length;
        int h = 0;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(citations[mid] >= citations.length - mid){

                end = mid - 1;
                h = citations.length - mid;

            } else {
                start = mid + 1;
            }

        }
        return h;
    }

    public static void main(String[] args) {
        HIndexII a = new HIndexII();
        int[] c = {0,1,3,5,6};
        System.out.println(a.hIndexBS(c));
    }

}
