package GrokkingCodingPatterns.Subsets;

//https://leetcode.com/problems/permutations/

/*

Time complexity #
We know that there are a total of N!N! permutations of a set with ‘N’ numbers. In the algorithm above,

we are iterating through all of these permutations with the help of the two ‘for’ loops. In each iteration,
 we go through all the current permutations to insert a new number in them on line 17 (line 23 for C++ solution).
 To insert a number into a permutation of size ‘N’ will take O(N),O(N), which makes the overall time complexity of
  our algorithm O(N*N!)O(N∗N!).

Space complexity #
All the additional space used by our algorithm is for the result list and the queue to store the intermediate permutations.
If you see closely, at any time, we don’t have more than N!N! permutations between the result list and the queue.
Therefore the overall space complexity to store N!N! permutations each containing NN elements will be O(N*N!)O(N∗N!).
 */
import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        backtracking(nums, result, new ArrayList<>());
        return result;
    }

    public static void backtracking(int[] nums, List<List<Integer>> arr, List<Integer> subarray) {
        if (subarray.size() == nums.length) {
            arr.add(new ArrayList<>(subarray));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (subarray.contains(nums[i])) continue;
            subarray.add(nums[i]);
            backtracking(nums, arr, subarray);
            subarray.remove(subarray.size() - 1);
        }
    }
}
