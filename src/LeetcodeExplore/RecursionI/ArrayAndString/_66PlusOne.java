package LeetcodeExplore.RecursionI.ArrayAndString;

import java.util.Arrays;

public class _66PlusOne {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1};
        Arrays.stream(plusOne(arr)).forEach(System.out::println);
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }

        int[] newnumber = new int[n+1];
        newnumber[0]=1;
        return newnumber;
    }
}
