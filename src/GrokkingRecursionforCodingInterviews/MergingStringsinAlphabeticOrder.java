package GrokkingRecursionforCodingInterviews;

public class MergingStringsinAlphabeticOrder {
    public static void main(String[] args) {
        System.out.println(alphabeticMerge("adz", "bfx"));
    }

    static String alphabeticMerge(String one, String two) {
        if (one.length() == 0)
            return two;
        else if (two.length() == 0)
            return one;
        else if (one.charAt(0) < two.charAt(0))
            return one.charAt(0) + alphabeticMerge(one.substring(1), two);
        return two.charAt(0) + alphabeticMerge(one, two.substring(1));
    }
}
