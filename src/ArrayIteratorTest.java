import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {
    public static void main(String[] args) {
        GenericArray<Integer> integers = new GenericArray<>();
        for (int i=0;i<20;i++){
            integers.add(i);
        }
        System.out.println(integers.size);

        Iterator<Integer> integers_Iterator = integers.iterator();
        while (integers_Iterator.hasNext()){
            System.out.print(integers_Iterator.next()+" ");
        }
    }
}