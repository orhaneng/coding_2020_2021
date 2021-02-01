package CodingBat.Recursion;
//https://codingbat.com/prob/p185204

/*
Given an array of ints, is it possible to divide the ints into two groups,
so that the sums of the two groups are the same. Every int must be in one
group or the other. Write a recursive helper method that takes whatever
 arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)
splitArray([2, 2]) → true
splitArray([2, 3]) → false
splitArray([5, 2, 3]) → true
 */

public class splitArray {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{5, 2, 3}));
    }

    public static boolean splitArray(int[] nums) {
        return help(nums, 0, 0, 0);
    }

    public static boolean help(int[] nums, int start, int sum1, int sum2) {
        System.out.print("sum1:" + sum1 + "sum2:" + sum2 );
        if (start >= nums.length) {
            System.out.println();
            return sum1 == sum2;
        }
        System.out.println(",nums[start]:" + nums[start]);

        return help(nums, start + 1, sum1 + nums[start], sum2) ||
                help(nums, start + 1, sum1, sum2 + nums[start]);
    }

}
