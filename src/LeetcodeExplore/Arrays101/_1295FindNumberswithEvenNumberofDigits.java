package LeetcodeExplore.Arrays101;
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class _1295FindNumberswithEvenNumberofDigits {
    public static int findNumbers(int[] nums) {
        int count = 1;
        int max=0;
        for(int i=0;i<nums.length;i++){
            count =1;
            int number = nums[i];
            while(number/10>0){
                number = number/10;
                count++;
            }
            max += count%2==0?1:0;
        }
        return max;
    }
}

