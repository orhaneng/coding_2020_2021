package GrokkingCodingPatterns.Subsets;

//https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    /*
    Problem Statement #
    Given a set with distinct elements, find all of its distinct subsets.

    Example 1:

    Input: [1, 3]
    Output: [], [1], [3], [1,3]
    Example 2:

    Input: [1, 5, 3]
    Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]



    Time complexity #
        Since, in each step, the number of subsets doubles as we add each element to all the existing subsets, the time complexity of the above algorithm is O(2^N)O(2
        ​N
        ​​ ), where ‘N’ is the total number of elements in the input set. This also means that, in the end, we will have a total of O(2^N)O(2
        ​N
        ​​ ) subsets.

        Space complexity #
        All the additional space used by our algorithm is for the output list. Since we will have a total of O(2^N)O(2
        ​N
        ​​ ) subsets, the space complexity of our algorithm is also O(2^N)O(2
        ​N
        ​​ ).


     */
    public static void main(String[] args) {
        subsets(new int[]{1, 3}).forEach(System.out::println);
    }
/*    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int currentNumber : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;


    }*/

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public static void backtracking(int[] nums, List<List<Integer>> list, List<Integer> templist, int start) {

        list.add(new ArrayList<>(templist));
        for (int i = start; i < nums.length; i++) {
            templist.add(nums[i]);
            backtracking(nums, list, templist, i + 1);
            templist.remove(templist.size() - 1);
        }

    }


}
