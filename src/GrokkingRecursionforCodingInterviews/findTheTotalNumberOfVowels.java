package GrokkingRecursionforCodingInterviews;

public class findTheTotalNumberOfVowels {

    public static void main(String[] args) {
        System.out.println(totalVowels("hELLo World", 0));
    }

    static int totalVowels(String text, int index) {
        char[] chars = {'A', 'E', 'I', 'O', 'U'};
        //Write your code here
        // Don't make changes to the input parameters

        if (index >= text.length())
            return 0;
        char ch = Character.toUpperCase(text.charAt(index));
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return 1 + totalVowels(text, index + 1);

        return totalVowels(text, index + 1);

    }


}

