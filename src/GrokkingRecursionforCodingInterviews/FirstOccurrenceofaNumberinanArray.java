package GrokkingRecursionforCodingInterviews;

public class FirstOccurrenceofaNumberinanArray {

    public static void main(String[] args) {

        int[] arr = {2, 4, 3, 1, 7, 8, 3};

        System.out.println(firstOccurrence(arr,0,3,0));
    }

    static int firstOccurrence(int array[], int size, int x, int currentIndex) {
        if (currentIndex >= array.length)
            return -1;
        if (array[currentIndex] == x)
            return currentIndex;
        return firstOccurrence(array, size, x, currentIndex + 1);
    }
}
