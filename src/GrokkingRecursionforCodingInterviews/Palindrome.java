package GrokkingRecursionforCodingInterviews;

public class Palindrome {

    public static void main(String[] args) {

        String text = "NONE";
        System.out.println(isPalindrome(text, 0, text.length() - 1));
    }

    static boolean isPalindrome(String text, int front, int back) {
        if (back < front)
            return true;

        if (text.charAt(front) != text.charAt(back))
            return false;

        return isPalindrome(text, front + 1, back - 1);
    }
}
