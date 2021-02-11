package GrokkingRecursionforCodingInterviews;

public class arrayPalindrome {

    boolean palindrome(int arr[], int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return true;

        if (arr[startIndex] != arr[endIndex])
            return false;

        return palindrome(arr, startIndex + 1, endIndex - 1);
    }
}
