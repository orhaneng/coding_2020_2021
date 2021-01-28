package CodingBat.Recursion;

//https://codingbat.com/prob/p161124
/*
    Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
    countAbc("abc") → 1
    countAbc("abcxxabc") → 2
    countAbc("abaxxaba") → 2
 */
public class countAbc {
    public int countAbc(String str) {
        if (str.length() < 3) {
            return 0;
        }
        if (str.charAt(0) == 'a' && str.charAt(1) == 'b'
                && (str.charAt(2) == 'a' || str.charAt(2) == 'c'))
            return countAbc(str.substring(2)) + 1;
        else
            return countAbc(str.substring(1));
    }

}
