import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    /**
         Given a sorted integer array without duplicates, return the summary of its ranges.

         Example 1:

         Input:  [0,1,2,4,5,7]
         Output: ["0->2","4->5","7"]
         Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
         Example 2:

         Input:  [0,2,3,4,6,8,9]
         Output: ["0","2->4","6","8->9"]
         Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

     */

    //Test case
//     [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
    // prev = 8 s = "8" i = 6
    //
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();

        int prev = nums[0];
        s.append(String.valueOf(nums[0]));

        for(int i = 1; i <= nums.length; i++) {
            if(i < nums.length && nums[i] == prev + 1) {
                prev += 1;
            } else {
                if(prev != Integer.valueOf(s.toString())) {
                    s.append(("->" + String.valueOf(prev)));
                }
                res.add(s.toString());
                if(i < nums.length) {
                    prev = nums[i];
                    s = new StringBuilder();
                    s.append(String.valueOf(nums[i]));
                }
            }

        }
        return res;
    }
}
