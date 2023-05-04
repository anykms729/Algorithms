import java.util.Iterator;

public class Lab3_Generic_Comparison_Sort_Functions<T extends Comparable<T>> {
    // Implement Generic Array
    public static void main(String[] args) {
        // Create Integer Array
        Lab3_Generic_Comparison_Sort_Functions<Integer> integers = new Lab3_Generic_Comparison_Sort_Functions();
        for (int i = 0; i < 20; i++) {
            integers.add((int) (Math.random()*900));
        }

        integers.selection_Sort();

        Iterator<Integer> integer_Iterator = integers.iterator();
        while (integer_Iterator.hasNext()) {
            System.out.print(integer_Iterator.next() + " ");
        }
        System.out.println();

        Lab3_Generic_Comparison_Sort_Functions<String> strings = new Lab3_Generic_Comparison_Sort_Functions<>();
        strings.add("Diso");
        strings.add("Biso");
        strings.add("Aiso");
        strings.add("Ciso");
        strings.selection_Sort();

        Iterator string_Iterator = strings.iterator();
        while (string_Iterator.hasNext()){
            System.out.print(string_Iterator.next()+" ");
        }
    }

    T[] generic_Array;
    // "size" variable will be used for "add()" method
    int size = 0;

    // Declare default constructor just in case user doesn't declare size of the array
    public Lab3_Generic_Comparison_Sort_Functions() {
        generic_Array = (T[]) (new Comparable[50]);
    }

    // Either user can declare size of the array
    public Lab3_Generic_Comparison_Sort_Functions(int n) {
        generic_Array = (T[]) (new Comparable[n]);
    }

    public void add(T element) {
        generic_Array[size] = element;
        size++;
    }

    public boolean search(T element) {
        int i = 0;
        boolean isFound = false;

        while (i < size && !isFound) {
            if (generic_Array[i].compareTo(element) == 0) {
                isFound = true;
            } else i++;
        }
        return isFound;
    }

    public void selection_Sort() {
        for (int i = 0; i < size - 1; i++) {
            int min_Index = i;
            for (int j = i + 1; j < size; j++) {
                if (generic_Array[j].compareTo(generic_Array[min_Index]) < 0) {
                    min_Index = j;
                }
            }
            T temp = generic_Array[i];
            generic_Array[i] = generic_Array[min_Index];
            generic_Array[min_Index] = temp;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayIterator<>(generic_Array, size);
    }

}
