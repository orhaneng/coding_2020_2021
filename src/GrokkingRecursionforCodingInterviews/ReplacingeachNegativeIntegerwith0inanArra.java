package GrokkingRecursionforCodingInterviews;

import java.util.Arrays;

public class ReplacingeachNegativeIntegerwith0inanArra {
    public static void main(String[] args) {
        int[] arr = {2, -3, 4, -1, -7, 8, 3};

        replaceNegativeValues(arr,0);
        Arrays.stream(arr).forEach(System.out::println);
    }

    static void replaceNegativeValues(int array[], int currentIndex) {
        if (currentIndex >= array.length)
            return;

        if (array[currentIndex] < 0)
            array[currentIndex] = 0;
        replaceNegativeValues(array, currentIndex + 1);
    }
}
