package LeetcodeExplore.HashTable;

import java.util.*;

public class _350IntersectionofTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        Arrays.stream(intersect(nums1, nums2)).forEach(System.out::println);

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                res.add(nums2[i]);
            }
        }

        int[] ret = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
