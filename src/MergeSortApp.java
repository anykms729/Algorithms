public class MergeSortApp {
    public static void main(String[] args) {
        int[] int_Array = {1, 3, 10, 5, 6, 25, 44, 52, 2, 16};
        mergeSort(int_Array);

        for (int t : int_Array) {
            System.out.print(t + " ");
        }
    }

    private static void mergeSort(int[] int_Array) {
        int length = int_Array.length;

        // Base case
        if (length <= 1) return;
        int mid = length / 2;

        // Divide
        int[] left_Array = new int[mid];
        int[] right_Array = new int[length - mid];

        int l = 0, r = 0;

        for (; l < length; l++) {
            if (l < mid) {
                left_Array[l] = int_Array[l];
            } else {
                right_Array[r] = int_Array[l];
                r++;
            }
        }
        mergeSort(left_Array);
        mergeSort(right_Array);
        merge(left_Array, right_Array, int_Array);
    }

    static void merge(int[] left_Array, int[] right_Array, int[] int_Array) {
        int left_Size = int_Array.length / 2;
        int right_Size = int_Array.length - left_Size;
        int l = 0, r = 0, i = 0;

        while (l < left_Size && r < right_Size) {
            if (left_Array[l] < right_Array[r]) {
                int_Array[i] = left_Array[l];
                i++;
                l++;
            } else {
                int_Array[i] = right_Array[r];
                i++;
                r++;
            }
        }
        while (l < left_Size) {
            int_Array[i] = left_Array[l];
            i++;
            l++;
        }
        while (r < right_Size){
            int_Array[i] = right_Array[r];
            i++;
            r++;
        }
    }
}



