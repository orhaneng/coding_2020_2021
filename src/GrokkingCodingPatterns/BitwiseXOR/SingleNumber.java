package GrokkingCodingPatterns.BitwiseXOR;

//https://leetcode.com/problems/single-number/

public class SingleNumber {

        /*

    Problem Statement #
    In a non-empty array of integers, every number appears twice except for one, find that single number.

    Example 1:

    Input: 1, 4, 2, 1, 3, 2, 3
    Output: 4
    Example 2:

    Input: 7, 9, 7
    Output: 9

     */


    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{7, 9, 7}));
    }

    public static int singleNumber(int[] nums) {
        int x1 = 0;
        for (int num : nums) x1 = x1 ^ num;
        return x1;
    }
}
