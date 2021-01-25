package CodingBat.Recursion;

//https://codingbat.com/prob/p105722

/*
Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
endX("xxre") &rarr; "rexx"
endX("xxhixx") &rarr; "hixxxx"
endX("xhixhix") &rarr; "hihixxx"

 */
public class endX {
    public String endX(String str) {
        if (str.length() == 0)
            return str;
        if (str.charAt(0) == 'x')
            return endX(str.substring(1)) + "x";
        return str.charAt(0) + endX(str.substring(1));
    }
}
