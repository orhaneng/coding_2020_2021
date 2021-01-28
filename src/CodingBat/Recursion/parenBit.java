package CodingBat.Recursion;
//https://codingbat.com/prob/p137918
/*

Given a string that contains a single pair of parenthesis,
compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".
parenBit("xyz(abc)123") → "(abc)"
parenBit("x(hello)") → "(hello)"
parenBit("(xy)1") → "(xy)"


 */
public class parenBit {
    public static void main(String[] args) {
        System.out.println(parenBit("not really (possible)"));
    }

    public static String parenBit(String str) {
        if(str.length()<1)
            return str;
        if(str.substring(0,1).equals("(")){
            if(str.substring(str.length()-1).equals(")")){
                return str;
            }else{
                return parenBit(str.substring(0,str.length()-1));
            }
        }
        return parenBit(str.substring(1));
    }


}
