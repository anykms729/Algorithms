import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] generic_Array;
    private int index =0;
    private int size;

    public ArrayIterator(T[] generic_Array, int size) {
        this.generic_Array = generic_Array;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return index< size;
    }

    @Override
    public T next() {
        if (index == size){
            throw new NoSuchElementException();
        }
        T next_Item = (T) generic_Array[index];
        index++;
        return next_Item;
    }

}
