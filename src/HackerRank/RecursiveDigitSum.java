package HackerRank;

//https://www.hackerrank.com/challenges/recursive-digit-sum/problem
/*
We define super digit of an integer  using the following rules:

Given an integer, we need to find the super digit of the integer.

If  has only  digit, then its super digit is .
Otherwise, the super digit of  is equal to the super digit of the sum of the digits of .
For example, the super digit of  will be calculated as:

	super_digit(9875)   	9+8+7+5 = 29
	super_digit(29) 	2 + 9 = 11
	super_digit(11)		1 + 1 = 2
	super_digit(2)		= 2
 */

public class RecursiveDigitSum {
    public static void main(String[] args) {
        System.out.println(superDigit("148", 3));
    }

    static int superDigit(String n, int k) {

        if (n.length() == 1)
            return Integer.valueOf(n);

        long sum = 0;
        int index = n.length() - 1;
        while (index >= 0) {
            sum += (n.charAt(index) - '0') * k;
            index--;
        }

        return superDigit(String.valueOf(sum), 1);
    }

//    static int superDigit(String n, int k) {
//        if (n.length() == 1)
//            return Integer.valueOf(n);
//
//        long sum = 0;
//        for (int i = 0; i < n.length(); i++) {
//            sum += (n.charAt(i) - '0') * k;
//        }
//
//        return superDigit(String.valueOf(sum),1);
//    }
}
