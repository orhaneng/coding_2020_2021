package GrokkingRecursionforCodingInterviews;

import java.util.Arrays;

public class SortanArray {
    public static void main(String[] args) {
        int[] arr = {3,2,9,1,8};

        SortArray(arr,0);

        Arrays.stream(arr).forEach(System.out::println);
    }


    static void SortArray(int arr[], int startIndex) {
        if (startIndex >= arr.length)
            return;

        int min = startIndex;

        for (int i = startIndex; i < arr.length; i++) {
            if (arr[min] > arr[i])
                min = i;
        }

        int temp = arr[startIndex];
        arr[startIndex] = arr[min];
        arr[min] = temp;

        SortArray(arr, startIndex + 1);

    }
}
