package GrokkingRecursionforCodingInterviews;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InvertthePositionElementsinanArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        reverseArray(arr,0,arr.length-1);

        Arrays.stream(arr).forEach(System.out::println);
    }

    static void reverseArray(int arr[], int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;

        int temp = arr[startIndex];
        arr[startIndex] = arr[endIndex];
        arr[endIndex] = temp;
        reverseArray(arr, startIndex + 1, endIndex - 1);
    }
}
