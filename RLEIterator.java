import java.util.LinkedList;
import java.util.Queue;

public class RLEIterator {


    int[] array;
    int index = 0;

    public RLEIterator(int[] A) {
        array = A;
    }

    public int next(int n) {
        if (index + 1 >= array.length) return -1;
        for (; n > 0; ) {
            if (array[index] >= n) {
                array[index] -= n;
                return array[index + 1];
            } else {
                n -= index;
                array[index] = 0;
                index += 2;
            }
            if (index + 1 >= array.length) return -1;
        }
        return array[index + 1];
    }

    public static void main(String[] args) {
        RLEIterator a = new RLEIterator(new int[] {3,8,0,9,2,5});
        System.out.println(a.next(2));
        System.out.println(a.next(1));
        System.out.println(a.next(1));
        System.out.println(a.next(2));

    }
}
