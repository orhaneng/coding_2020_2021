package GrokkingDynamicProgrammingPatterns;

//https://leetcode.com/problems/partition-equal-subset-sum/

public class EqualSubsetSumPartition {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        //System.out.println(EqualSubsetSumPartitionBruteForce.canPartition(nums));
        System.out.println(EqualSubsetSumPartitionTopdownDynamicProgrammingwithMemoization.canPartition(nums));
    }
}

class EqualSubsetSumPartitionBruteForce {


    /*
    The time complexity of the above algorithm is exponential O(2^n)O(2
    ​n
    ​​ ), where ‘n’ represents the total number. The space complexity is O(n)O(n),
    this memory which will be used to store the recursion stack.

     */
    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        return recursive(nums, (sum) / 2, 0);


    }

    public static boolean recursive(int[] nums, int sum, int currentIndex) {

        if (sum == 0)
            return true;
        if (nums.length == 0 || currentIndex >= nums.length) {
            return false;
        }

        if (nums[currentIndex] <= sum) {
            if (recursive(nums, sum - nums[currentIndex], currentIndex + 1)) {
                return true;
            }
        }
        return recursive(nums, sum, currentIndex + 1);
    }
}

class EqualSubsetSumPartitionTopdownDynamicProgrammingwithMemoization {

    /*
    The above algorithm has time and space complexity of O(N*S)O(N∗S), where ‘N’ represents total numbers and ‘S’ is
     the total sum of all the numbers.

     */
    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];

        return recursive(dp, nums, sum / 2, 0);

    }

    public static boolean recursive(Boolean[][] dp, int[] nums, int sum, int currentIndex) {

        if (sum == 0)
            return true;

        if (nums.length == 0 || currentIndex >= nums.length) {
            return false;
        }

        if (dp[currentIndex][sum] == null) {
            if (nums[currentIndex] <= sum) {
                if (dp[currentIndex][sum] = recursive(dp, nums, sum - nums[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }
            dp[currentIndex][sum] = recursive(dp, nums, sum, currentIndex + 1);
        }
        return dp[currentIndex][sum];
    }
}

class EqualSubsetSumPartitionBottomupDynamicProgramming {
    public static boolean canPartition(int[] nums) {

        /*
        The above solution has time and space complexity of O(N*S)O(N∗S), where ‘N’ represents total numbers and ‘S’ is the total sum of all the numbers.
         */
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }


        if (sum % 2 != 0) return false;

        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            dp[0][i] = (nums[0] == i ? true : false);
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= nums[i]) {
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }
            }
        }

        return dp[n - 1][sum];

    }

}