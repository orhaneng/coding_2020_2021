package GrokkingCodingPatterns.Top_K_Elements;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Time complexity #
The time complexity of the above algorithm is O(logN + K)O(logN+K). We need O(logN)O(logN) for
Binary Search and O(K)O(K) for finding the ‘K’ closest numbers using the two pointers.

Space complexity #
If we ignoring the space required for the output list, the algorithm runs in constant space O(1)O(1).

Mark as Completed


 */
public class KClosestNumbers {
    public static void main(String[] args) {
        findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8},3,5).forEach(System.out::println);
    }

    static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);

        int low = index - k, high = index + k;
        low = Math.max(0, low);
        high = Math.min(arr.length - 1, high);

        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>((a, b) -> a.key - b.key);
        for (int i = low; i <= high; i++) {
            minHeap.add(new Entry(Math.abs(arr[i] - x), i));
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(arr[minHeap.poll().value]);
        }
        return result;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        if (low > 0)
            return low - 1;
        return low;
    }
}
