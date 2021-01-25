package CodingBat.Recursion;

//https://codingbat.com/prob/p170371
/*

Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
countX("xxhixx") → 4
countX("xhixhix") → 3
countX("hi") → 0
 */
public class countX {

    public static void main(String[] args) {
        System.out.println(countX("xxhixx"));
    }

    public static int countX(String str) {
        return help(str, 0);

    }

    public static int help(String str, int digit) {
        if (digit >= str.length())
            return 0;
        else {
            if (str.charAt(digit) == 'x') {
                return help(str, digit + 1) + 1;
            } else {
                return help(str, digit + 1);
            }
        }
    }

    public int countX2(String str) {
        int count = 0;
        if (str.length() < 1)
            return 0;
        if (str.charAt(0) == 'x') {
            count = 1;
        }
        return countX2(str.substring(1)) + count;
    }
}
