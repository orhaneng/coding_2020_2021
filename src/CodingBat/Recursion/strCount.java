package CodingBat.Recursion;
//https://codingbat.com/prob/p186177

/*

Given a string and a non-empty substring sub, compute recursively the number
of times that sub appears in the string, without the sub strings overlapping.
strCount("catcowcat", "cat") → 2
strCount("catcowcat", "cow") → 1
strCount("catcowcat", "dog") → 0
 */
public class strCount {
    public static void main(String[] args) {
        System.out.println(strCount("xyx", "x"));
    }

    public static int strCount(String str, String sub) {
        if (str.length() < sub.length())
            return 0;

        if (str.substring(0, sub.length()).equals(sub))
            return strCount(str.substring(sub.length()), sub) + 1;
        return strCount(str.substring(1), sub);
    }

}
