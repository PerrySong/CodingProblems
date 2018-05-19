import java.util.Iterator;
import java.util.LinkedList;

public class PeekingIterator implements Iterator<Integer>{
    Iterator iterator;
    Integer next;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if(iterator.hasNext())
            next = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = next;
        if(iterator.hasNext())
            next = (Integer)iterator.next();
        else
            next = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
