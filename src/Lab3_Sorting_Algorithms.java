public class Lab3_Sorting_Algorithms {
    public static void main(String[] args) {
        Integer[] integers = new Integer[100];
        for (int index=0; index<integers.length;index++){
            integers[index] = (int)(Math.random()*800);
        }

        long Bubble_Sort_Start = System.currentTimeMillis();
        compute_Bubble_Sort(integers);
        long Bubble_Sort_End = System.currentTimeMillis();
        long Bubble_Sort_ElapsedTime = Bubble_Sort_End - Bubble_Sort_Start;
        System.out.println("Bubble_Sort_ElapsedTime: " + Bubble_Sort_ElapsedTime);

        long Selection_Sort_Start = System.currentTimeMillis();
        compute_Selection_Sort(integers);
        long Selection_Sort_End = System.currentTimeMillis();
        long Selection_Sort_ElapsedTime = Selection_Sort_End - Selection_Sort_Start;
        System.out.println("Selection_Sort_ElapsedTime: " + Selection_Sort_ElapsedTime);

        long Insertion_Sort_Start = System.currentTimeMillis();
        compute_Insertion_Sort(integers);
        long Insertion_Sort_End = System.currentTimeMillis();
        long Insertion_Sort_ElapsedTime = Insertion_Sort_End - Insertion_Sort_Start;
        System.out.println("Insertion_Sort_ElapsedTime: " + Insertion_Sort_ElapsedTime);
    }

    public static void compute_Bubble_Sort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.print("Array after sorted by Bubble Sort: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }

    public static void compute_Insertion_Sort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
        }
        System.out.print("Array after sorted by Insertion Sort: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }

    // (5) Selection Sort
    public static void compute_Selection_Sort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min_Value_Index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min_Value_Index] > array[j]) {
                    min_Value_Index = j;
                }
            }
            int temp = array[i];
            array[i] = array[min_Value_Index];
            array[min_Value_Index] = temp;
        }
        System.out.print("Array after sorted by Selection Sort: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }
}

