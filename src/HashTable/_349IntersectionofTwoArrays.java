package HashTable;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class _349IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> interset = new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                interset.add(nums2[i]);
            }
        }
        int[] res = new int[interset.size()];
        int i=0;
        for(int num : interset){
            res[i++] =num;
        }
        return res;
    }
}
