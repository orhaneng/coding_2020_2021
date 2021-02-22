package GrokkingCodingPatterns.BitwiseXOR;

import java.util.Arrays;



/*

Time Complexity #
The time complexity of this solution is O(n)O(n) where ‘n’ is the number of elements in the input array.

Space Complexity #
The algorithm runs in constant space O(1).

Problem Statement #
In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once.
Find the two numbers that appear only once.

Example 1:

Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
Output: [4, 6]
Example 2:

Input: [2, 1, 3, 2]
Output: [1, 3]


 */
public class TwoSingleNumbers {
    public static void main(String[] args) {
        Arrays.stream(findsingleNumbers(new int[]{4, 2, 6, 2})).forEach(System.out::println);
    }

    public static int[] findsingleNumbers(int[] nums) {
        int x1x2 = 0;
        for (int num : nums) {
            x1x2 ^= num;
        }
        int rightmostsetbit = 1;
        while ((rightmostsetbit & x1x2) == 0)
            rightmostsetbit = rightmostsetbit << 1;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostsetbit) != 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }
}

