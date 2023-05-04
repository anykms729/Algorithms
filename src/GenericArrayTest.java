import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayTest {
    public static void main(String[] args) {
        // Creating an int type array
        GenericArray<Integer> integers = new GenericArray<Integer>();
        for (int i = 0; i < 20; i++) {
            integers.add((int) (Math.random()*900));
        }
        integers.selectionSort();

        Iterator<Integer> integer_Iterator = integers.iterator();
        while (integer_Iterator.hasNext()){
            System.out.print(integer_Iterator.next()+" ");
        }
        System.out.println();

        // Creating a String type array
        GenericArray<String> strings = new GenericArray<String>();
        strings.add("Z");
        strings.add("MKE");
        strings.add("C");
        strings.add("A");
        strings.selectionSort();
        System.out.println(strings.search("MKE"));

        Iterator<String> string_Iterator = strings.iterator();
        while (string_Iterator.hasNext()) {
            System.out.print(string_Iterator.next()+" ");
        }
    }
}