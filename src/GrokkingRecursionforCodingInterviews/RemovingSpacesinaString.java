package GrokkingRecursionforCodingInterviews;

public class RemovingSpacesinaString {
    public static void main(String[] args) {
        System.out.println(removeSpaces("hi hey hello",0,0));
    }

   static String removeSpaces(String text, int index, int len) {
        if (index >= text.length()-len) {
            return text;
        }

        if (text.charAt(index) == ' ') {
            len++;
            text = text.substring(0, index) + text.substring(index + 1);
        }

        return removeSpaces(text, index + 1, len);
    }
}
