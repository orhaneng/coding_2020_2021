package GrokkingCodingPatterns.TwoPointers;

import java.util.Arrays;

public class PairwithTargetSum {
    public static void main(String[] args) {
        Arrays.stream(search(new int[]{3,2,4},6)).forEach(System.out::println);
    }

    public static int[] search(int[] arr, int targetSum) {
        if (arr.length == 0) return new int[]{-1,-1};
        int begin=0, end = arr.length-1;
        while (begin<end){
            if(arr[begin]+arr[end]==targetSum){
                return new int[]{begin,end};
            }else if (arr[begin]+arr[end]>targetSum){
                end--;
            }else{
                begin++;
            }
        }
        return new int[]{-1,-1};
    }
}
