package LeetcodeExplore.Arrays101;

import java.util.Arrays;


//https://leetcode.com/problems/duplicate-zeros/
public class _1089DuplicateZeros {

    public static void main(String[] args) {
        int[] nums = {1,0,2,3,0,4,5,0};
        duplicateZeros4(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public void BruteduplicateZeros(int[] arr) {
        int length= arr.length;  // 7
        for(int i=0;i<length-1;i++){  //i=0
            if(arr[i]==0){   //
                for(int j=length-1;j>i;j--){ //j =1  i=0
                    arr[j]= arr[j-1];  //
                }
                arr[i+1]=0;
                i++;
            }
        }
    }
    public static void duplicateZeros(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) countZero++;
        }
        int len = arr.length + countZero;
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
                j--;
                if (j < arr.length) {
                    arr[j] = arr[i]; //copy twice when hit '0'
                }
            }
        }
    }
    public static void duplicateZeros4(int[] arr) {

        int count = (int)Arrays.stream(arr).filter(i->i==0).count(); //3
        int arrcount = arr.length+count; //10
        for(int i=arr.length-1;;i--){  //7,6
            if(arr[i]==0){ //T,F
                if(arrcount<arr.length){
                    arr[i] = arr[arrcount];
                }
                arrcount--;//
                if(arrcount<arr.length){
                    arr[i] = arr[arrcount];
                }
            }else{//T
                if(arrcount<arr.length){
                    arr[arrcount]=arr[i];//[1,0,2,3,0,4,5,0,5,0,0]
                }
            }
            arrcount--;//
        }
    }
}
