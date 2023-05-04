import java.util.Iterator;

public class GenericArray<T extends Comparable<T>> {
    // Java Comparable interface is used to order the objects of the user-defined class
    // Implement comparable

    public static void main(String[] args) {
        GenericArray<String> strings = new GenericArray<String>();
        strings.add("Ciso");
        strings.add("Diso");
        strings.add("Aiso");
        strings.add("Biso");

        strings.selectionSort();
        Iterator<String> string_Iterator = strings.iterator();
        while (string_Iterator.hasNext()){
            System.out.print(string_Iterator.next()+" ");
        }
    }

    private T[] data;
    int size = 0;

    public GenericArray() {
        data = (T[]) (new Comparable[50]);
    }

    // User-defined Array length
    public GenericArray(int n) {
        data = (T[]) (new Comparable[n]);
    }

    public void add(T element) {
        // Add at the last index of the array
        data[size] = element;
        size++;
    }


    // Generic programming - comparable search
    public boolean search(T element) {
        int j = 0;
        boolean found = false;
        while (j < size && !found) {
            if (data[j].compareTo(element) == 0) {
                found = true;
            } else j++;
        }
        return found;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min_Index = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[min_Index]) < 0) {
                    min_Index = j;
                }
            }
            T temp = data[i];
            data[i] = data[min_Index];
            data[min_Index] = temp;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayIterator<>(data, size);
    }

}
