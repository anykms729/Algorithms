import java.util.Arrays;

public class MergeSort extends Thread {
    private int[] array;
    private int left;
    private int right;

    public MergeSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }
     public void run() {
        if (left < right) {
            int middle = (left + right) / 2;

            // Create two threads to sort the left and right subarrays in parallel
            MergeSort t1 = new MergeSort(array, left, middle);
            MergeSort t2 = new MergeSort(array, middle + 1, right);

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();

                // Merge the sorted subarrays
                int[] temp = new int[right - left + 1];
                int i = left, j = middle + 1, k = 0;
                while (i <= middle && j <= right) {
                    if (array[i] <= array[j]) {
                        temp[k++] = array[i++];
                    } else {
                        temp[k++] = array[j++];
                    }
                }
                while (i <= middle) {
                    temp[k++] = array[i++];
                }
                while (j <= right) {
                    temp[k++] = array[j++];
                }
                for (i = left, k = 0; i <= right; i++, k++) {
                    array[i] = temp[k];
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 1000);
        }

        // Create two threads to sort the left and right subarrays in parallel
        MergeSort t1 = new MergeSort(data, 0, data.length / 2 - 1);
        MergeSort t2 = new MergeSort(data, data.length / 2, data.length - 1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(data));
    }
}

