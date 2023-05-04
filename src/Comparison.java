import java.lang.*;

public class Comparison {
    static void bubbleSort(int[] arr) {
        int arr_length = arr.length;
        int temp = 0;
        // outer keeps track of each pass through the array
        for (int outer = 0; outer < arr_length; outer++) {
            //inner compares each pair and does a swap
            for (int inner = 1; inner < (arr_length - outer); inner++) {
                if (arr[inner - 1] > arr[inner]) {
                    // do a swap if the above is true
                    temp = arr[inner - 1];
                    arr[inner - 1] = arr[inner];
                    arr[inner] = temp;
                }
            }
        }
    }

    static int[] createRandoms(int size) {
        int random_arr[] = new int[size];
        //assign randoms to arr1
        for (int i = 0; i < random_arr.length; i++) {
            random_arr[i] = (int) (Math.random() * 100);
        }
        return random_arr;
    }

    static void printArray(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + ", ");
        }
        System.out.println();
    }

    static void selectionSort(int[] arr, int lowerBound, int upperBound) {
        // outer loop does n passes through array
        for (int pass = lowerBound; pass < upperBound; pass++) {
            int smallest_index = pass;
            for (int query_index = pass + 1; query_index < upperBound; query_index++) {
                if (arr[query_index] < arr[smallest_index]) {
                    smallest_index = query_index;
                }
            }
            int temp = arr[pass];
            arr[pass] = arr[smallest_index];
            arr[smallest_index] = temp;
        }
    }

    static int[] copyArray(int[] arr) {
        int[] copy_arr = new int[arr.length];
        for (int i = 0; i < copy_arr.length; i++) {
            copy_arr[i] = arr[i];
        }
        return copy_arr;
    }

    static void insertionSort(int[] arr) {
        int query = 1;
        while (query < arr.length) {
            int predecessor = query;
            while (predecessor > 0 && arr[predecessor] < arr[predecessor - 1]) {
                int temp = arr[predecessor];
                arr[predecessor] = arr[predecessor - 1];
                arr[predecessor - 1] = temp;
                predecessor = predecessor - 1;
            }
            query = query + 1;
        }
    }


    static void merge(int[] currentArray, int lowerB, int mid, int upperB) {
        int leftSideIndex = lowerB;
        int rightSideIndex = mid;

        // temporary array which will contain sorted values
        // going from lower bound to upper bound
        int sortedSubArray[] = new int[upperB - lowerB];
        int toBeSortedIndex = 0;


        // this loop is comparing to two smaller arrays
        while (leftSideIndex < mid && rightSideIndex < upperB) {
            if (currentArray[leftSideIndex] <= currentArray[rightSideIndex]) {
                sortedSubArray[toBeSortedIndex] = currentArray[leftSideIndex];
                leftSideIndex++;
                toBeSortedIndex++;
            } else {
                sortedSubArray[toBeSortedIndex] = currentArray[rightSideIndex];
                rightSideIndex++;
                toBeSortedIndex++;
            }
        }

        // one half of the array has already been allocated at this point
        // now we need to allocate the other array
        while (leftSideIndex < mid) {
            sortedSubArray[toBeSortedIndex] = currentArray[leftSideIndex];
            leftSideIndex++;
            toBeSortedIndex++;
        }
        while (rightSideIndex < upperB) {
            sortedSubArray[toBeSortedIndex] = currentArray[rightSideIndex];
            rightSideIndex++;
            toBeSortedIndex++;
        }


        // copy data from sorted sub array to currentArray
        leftSideIndex = lowerB;
        toBeSortedIndex = 0;
        while (toBeSortedIndex < sortedSubArray.length) {
            currentArray[leftSideIndex] = sortedSubArray[toBeSortedIndex];
            leftSideIndex++;
            toBeSortedIndex++;
        }
    }


    static void testingSort(int size) {
        int[] arr1 = createRandoms(size);


        System.out.println("Size of data: N=" + size);
        Thread s1 = new Thread(new SelectionSort(arr1, 0, size / 2));
        Thread s2 = new Thread(new SelectionSort(arr1, size / 2, size));

        System.out.println("The array before sorting");
        printArray(arr1);

        //selectionSort(arr1, 0, size);
        s1.start();
        s2.start();

        try {
            s1.join();
            s2.join();
        } catch (InterruptedException e) {
        }

        merge(arr1, 0, size / 2, size);

        System.out.println("The array after sorting");
        printArray(arr1);
    }


    public static void main(String args[]) {

        testingSort(100);

    }

    public static class SelectionSort implements Runnable {

        int upperBound;
        int lowerBound;
        int[] arr;

        SelectionSort(int[] arr, int lowerBound, int upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.arr = arr;
        }


        public void run() {

            // outer loop does n passes through array
            for (int pass = lowerBound; pass < upperBound; pass++) {
                int smallest_index = pass;
                for (int query_index = pass + 1; query_index < upperBound; query_index++) {
                    if (arr[query_index] < arr[smallest_index]) {
                        smallest_index = query_index;
                    }
                }
                int temp = arr[pass];
                arr[pass] = arr[smallest_index];
                arr[smallest_index] = temp;
            }
        }
    }

}
