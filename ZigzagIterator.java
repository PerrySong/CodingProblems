import java.util.List;

public class ZigzagIterator {
    /**
     *
         Given two 1d vectors, implement an iterator to return their elements alternately.

         Example:

         Input:
         v1 = [1,2]
         v2 = [3,4,5,6]

         Output: [1,3,2,4,5,6]

         Explanation: By calling next repeatedly until hasNext returns false,
         the order of elements returned by next should be: [1,3,2,4,5,6].
         Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

         Clarification for the follow up question:
         The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:

         Input:
         [1,2,3]
         [4,5,6,7]
         [8,9]

         Output: [1,4,8,2,5,9,3,6,7].

        Time: O(1);
        Space: O(n);
     */

    List<Integer> v1;
    List<Integer> v2;
    int i1;
    int i2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        i1 = 0;
        i2 = 0;
    }

    public int next() {
        if(i1 <= i2 && i1 < v1.size()|| i2 >= v2.size())
            return v1.get(i1++);
        else
            return v2.get(i2++);
    }

    public boolean hasNext() {
        return (i1 < v1.size() || i2 < v2.size());
    }
}
