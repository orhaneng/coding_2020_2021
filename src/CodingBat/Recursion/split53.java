package CodingBat.Recursion;

public class split53 {

    public static void main(String[] args) {
        System.out.println(split53(new int[]{2, 4, 2}));
    }

    public static boolean split53(int[] nums) {
        return helper(nums, 0, 0, 0);
    }

    public static boolean helper(int[] nums, int start, int sum1, int sum2) {
        if (start >= nums.length)
            return sum1 == sum2;
        int value = nums[start];

        if (value % 5 == 0)
            return helper(nums, start + 1, sum1 + value, sum2);
        else if (value % 3 == 0)
            return helper(nums, start + 1, sum1, sum2 + value);
        else
            return helper(nums, start + 1, sum1 + nums[start], sum2) ||
                    helper(nums, start + 1, sum1, sum2 + nums[start]);
    }

}
