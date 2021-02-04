package GrokkingRecursionforCodingInterviews;

public class RemovingDuplicatesinaString {

    public static void main(String[] args) {
        System.out.println(remDuplicates("Hello Woorldd", 0));
    }

    static String remDuplicates(String text, int index) {
        if (index >= text.length()) {
            return text;
        }

        if (text.charAt(index) == text.charAt(index + 1)) {
            text = text.substring(0, index) + text.substring(index + 1);
        }

        return remDuplicates(text, index + 1);
    }
}

