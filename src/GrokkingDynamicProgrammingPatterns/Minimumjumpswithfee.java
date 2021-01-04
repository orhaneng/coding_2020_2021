package GrokkingDynamicProgrammingPatterns;

public class Minimumjumpswithfee {

    /*
    Problem Statement #
Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the fee that you have to pay if you take the step. Implement a method to calculate the minimum fee required to reach the top of the staircase (beyond the top-most step). At every step, you have an option to take either 1 step, 2 steps, or 3 steps. You should assume that you are standing at the first step.

Example 1:

Number of stairs (n) : 6
Fee: {1,2,5,2,1,2}
Output: 3
Explanation: Starting from index '0', we can reach the top through: 0->3->top
The total fee we have to pay will be (1+2).
Example 2:

Number of stairs (n): 4
Fee: {2,3,4,5}
Output: 5
Explanation: Starting from index '0', we can reach the top through: 0->1->top
The total fee we have to pay will be (2+3).

     */

    public static void main(String[] args) {
        int[] fees = {1, 2, 5, 2, 1, 2};
        //System.out.println(MinimumjumpswithfeeBruteForce.findMinFee(fees));
        //System.out.println(MinimumjumpswithfeeTopdownDynamicProgrammingwithMemoization.findMinFee(fees));
        System.out.println(MinimumjumpswithfeeBottomupDynamicProgramming.findMinFee(fees));
    }
}


class MinimumjumpswithfeeBruteForce {
    public static int findMinFee(int[] fee) {
        return findMinFeeRecursive(fee, 0);
        /*
        The time complexity of the above algorithm is exponential O(3^n)O(3

​​ ). The space complexity is O(n)O(n) which is used to store the recursion stack.
         */
    }

    private static int findMinFeeRecursive(int[] fee, int currentIndex) {
        if (currentIndex > fee.length - 1) {
            return 0;
        }

        int take1step = findMinFeeRecursive(fee, currentIndex + 1);
        int take2step = findMinFeeRecursive(fee, currentIndex + 2);
        int take3step = findMinFeeRecursive(fee, currentIndex + 3);

        int min = Math.min(Math.min(take1step, take2step), take3step);

        return min + fee[currentIndex];

    }
}

class MinimumjumpswithfeeTopdownDynamicProgrammingwithMemoization {

    public static int findMinFee(int[] fee) {
        int[] dp = new int[fee.length];
        return findMinFeeRecursive(dp, fee, 0);
    }

    private static int findMinFeeRecursive(int[] dp, int[] fee, int currentIndex) {
        if (currentIndex > fee.length - 1) {
            return 0;
        }

        if (dp[currentIndex] == 0) {
            int take1step = findMinFeeRecursive(dp, fee, currentIndex + 1);
            int take2step = findMinFeeRecursive(dp, fee, currentIndex + 2);
            int take3step = findMinFeeRecursive(dp, fee, currentIndex + 3);

            int min = Math.min(Math.min(take1step, take2step), take3step);
            dp[currentIndex] = min + fee[currentIndex];

        }
        return dp[currentIndex];

    }
}

class MinimumjumpswithfeeBottomupDynamicProgramming {
    //The above solution has time and space complexity of O(n)O(n).
    public static int findMinFee(int[] fee) {
        int[] dp = new int[fee.length + 1];
        dp[0] = 0;
        dp[1] = fee[0];
        dp[2] = dp[3] = fee[0];

        for (int i = 3; i < fee.length; i++) {
            dp[i + 1] = Math.min(fee[i] + dp[i], Math.min(fee[i - 1] + dp[i - 1], fee[i - 2] + dp[i - 2]));
        }
        return dp[fee.length];
    }
}