package ss13_sort;

import java.util.Arrays;

public class InsertionSortSetup {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        System.out.println("Mảng chưa sắp xếp" + Arrays.toString(array));
        insertionSort(array);
        System.out.println("Mảng sau khi được sắp xếp: " + Arrays.toString(array));
    }

}
