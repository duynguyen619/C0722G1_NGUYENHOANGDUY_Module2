package ss12_search_algorithm;

import java.util.Arrays;

public class BinarySearch {
    int binarySearch(int[] arr, int left, int right, int k) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == k)
                return mid;
            if (arr[mid] > k)
                return binarySearch(arr, left, mid - 1, k);
            return binarySearch(arr, mid + 1, right, k);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int[] arr = {3, 4, 1, 6, 7, 8, 5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        int k = 3;
        int result = ob.binarySearch(arr, 0, n - 1, k);
        if (result == -1)
            System.out.println("Không tìm thấy phần tử " + k);
        else
            System.out.println("Phần tử " + k + " được tìm thấy tại chỉ số " + result);
    }
}
