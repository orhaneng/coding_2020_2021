package LeetcodeExplore.RecursionI.ArrayAndString;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class _167TwoSumIIInputarrayisSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers.length == 0){//3
            return res;
        }

        int begin =0;
        int end = numbers.length-1;

        while(begin<end){
            if(numbers[begin]+numbers[end]==target){
                res[0]=begin+1;
                res[1]= end+1;
                return res;
            }
            if(numbers[begin]+numbers[end]>target){
                end--;
            }
            if(numbers[begin]+numbers[end]<target){
                begin++;
            }
        }
        return res;
    }
}
