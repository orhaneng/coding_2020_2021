package LeetcodeExplore.RecursionI.Arrays101;
//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

public class _1299ReplaceElementswithGreatestElementonRightSide {

    public int[] replaceElements(int[] arr) {
        int temp;
        int max=-1;
        for(int i=arr.length-1;i>=0;i--){
            temp = arr[i];
            arr[i]=max;
            max = Math.max(max,temp);
        }
        return arr;
    }
    public int[] replaceElements2(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int fast=i+1;
            int max = Integer.MIN_VALUE;
            while(fast<arr.length){
                max = Math.max(arr[fast], max);
                fast++;
            }
            arr[i]=max;
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}
