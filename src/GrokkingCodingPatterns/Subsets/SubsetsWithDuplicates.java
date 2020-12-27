package GrokkingCodingPatterns.Subsets;

//https://leetcode.com/problems/subsets-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Time complexity #
Since, in each step, the number of subsets could double (if not duplicate) as we add each element to all the existing subsets,
the time complexity of the above algorithm is O(2^N)O(2
​N
​​ ), where ‘N’ is the total number of elements in the input set. This also means that, in the end, we will have a total of O(2^N)O(2
​N
​​ ) subsets at the most.

Space complexity #
All the additional space used by our algorithm is for the output list. Since at most we will have a total of O(2^N)O(2
​N
​​ ) subsets, the space complexity of our algorithm is also O(2^N)O(2
​N
​​ ).


 */
public class SubsetsWithDuplicates {
    public static void main(String[] args) {
        findSubsets(new int[]{1, 5, 3, 3}).forEach(System.out::println);
    }

    public static List<List<Integer>> findsubsets(int[] nums) {
        List<List<Integer>> sublist = new ArrayList<>();
        sublist.add(new ArrayList<>());

        for (Integer num : nums) {
            int size = sublist.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(sublist.get(i));
                list.add(num);

                if(!sublist.contains(list))
                    sublist.add(list);
            }
        }
        return sublist;
    }
    public static List<List<Integer>> findSubsets(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            startIndex = 0;

            if (i > 0 && nums[i] == nums[i - 1])

                startIndex = endIndex + 1;

            endIndex = subsets.size() - 1;

            for (int j = startIndex; j <= endIndex; j++) {

                List<Integer> set = new ArrayList<>(subsets.get(j));

                set.add(nums[i]);

                subsets.add(set);

            }

        }

        return subsets;

    }
}
