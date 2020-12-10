package LeetcodeExplore.BinarySearch;

//https://leetcode.com/problems/find-peak-element/

public class _162FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,6,1,3,5,1,4}));
    }
    public static int findPeakElement(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;
        while(low < high) {
            mid = low + (high-low)/2;
            if(a[mid] < a[mid+1])
            {
                low = mid+1;
            }
            else high = mid;
        }
        return low;
    }
}
