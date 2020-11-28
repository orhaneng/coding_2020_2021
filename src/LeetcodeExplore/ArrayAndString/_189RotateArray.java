package LeetcodeExplore.ArrayAndString;
//https://leetcode.com/problems/rotate-array/

public class _189RotateArray {
    public void rotate(int[] nums, int k) {
        k %=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp= arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
