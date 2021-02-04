package GrokkingRecursionforCodingInterviews;

public class CounttheNumberofOccurrencesofaNumberinanArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 1, 3, 8, 3};
        System.out.println(noOfOccurrence(arr, arr.length - 1, 3));
    }

    static int noOfOccurrence(int array[], int size, int num) {
        if (size < 0)
            return 0;

        if (array[size] == num)
            return noOfOccurrence(array, size - 1, num) + 1;
        return noOfOccurrence(array, size - 1, num);

    }
}
