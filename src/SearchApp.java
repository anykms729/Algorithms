import java.util.Scanner;

public class SearchApp {
    public static void main(String args[]) {

        int[] arr = {1, 100, 10, 11, 13, 5000};
        Scanner sc = new Scanner(System.in);

        int query = sc.nextInt();

        int indexOfQuery = linearSearch(arr, query);

        System.out.println("LINEAR SEARCH: The query: " + query + " is at position: " + indexOfQuery);

        int indexOfQuery_binarySearch = binarySearch(arr, query);
        System.out.println("BINARY SEARCH: The query: " + query + " is at position: " + indexOfQuery_binarySearch);
    }


    static int binarySearch(int[] arr, int query) {
        int upperB = arr.length;
        int lowerB = 0;

        long start_Time = System.nanoTime();

        while (lowerB <= upperB) {
            int mid = (upperB + lowerB) / 2;
            if (arr[mid] == query) {
                return mid;
            } else if (arr[mid] > query) {
                upperB = mid - 1;
            } else {
                lowerB = mid + 1;
            }
            long end_Time = System.nanoTime();
            long duration = end_Time - start_Time;
            System.out.println("Binary takes " + duration);
        }
        return -1;

    }


    static int linearSearch(int[] arr, int query) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == query) {
                return i; // Return the index where query is found
            }
        }
        return -1; // Return -1 if query is not found in the array
    }
}