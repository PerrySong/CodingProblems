import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> que = new ArrayDeque<Integer>();// Store elems indexes
        int ri = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!que.isEmpty() && que.peek() < i - k + 1) {
                que.pollFirst();
            }
            while(!que.isEmpty() && nums[que.peekLast()] <= nums[i]) {
                que.pollLast();
            }
            que.offer(i);
            if(i >= k - 1) {
                res[ri++] = nums[que.peekFirst()];
            }

        }
        return res;
    }
    public static void main(String[] args) {
        SlidingWindowMaximum a = new SlidingWindowMaximum();
        int[] b = {1,3,-1,-3,5,3,6,7};
        a.maxSlidingWindow(b, 3);
    }
}
