package GrokkingRecursionforCodingInterviews;

import java.util.Arrays;

public class ReversingaString {

    public static void main(String[] args) {

        String text = "hello";

       char[] arr = reverseString(text.toCharArray(), 0);
        System.out.println(arr);
    }

    static char[] reverseString(char[] reversee, int index) {
        if (index >= reversee.length / 2)
            return reversee;

        char temp = reversee[index];
        reversee[index] = reversee[reversee.length - 1 - index];
        reversee[reversee.length - 1 - index] = temp;

        return reverseString(reversee, index + 1);
    }

}
