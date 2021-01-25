package CodingBat.Recursion;
//https://codingbat.com/prob/p101372
/*

Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.


changeXY("codex") → "codey"
changeXY("xxhixx") → "yyhiyy"
changeXY("xhixhix") → "yhiyhiy"
 */
public class changeXY {

    public String changeXY(String str) {
        if(str.length()==0) return str;
        if(str.charAt(0)=='x')
            return 'y'+changeXY(str.substring(1));
        else
            return str.charAt(0)+changeXY(str.substring(1));
    }

/*    public String changeXY(String str) {
        if(str.length()==0) return str;
        return String.valueOf(help(str.toCharArray(),0));
    }

    public char[] help(char[] arr, int index){
        if(index==arr.length)
            return arr;

        if(arr[index]=='x'){
            arr[index]='y';
        }
        return help(arr,index+1);
    }*/

}
