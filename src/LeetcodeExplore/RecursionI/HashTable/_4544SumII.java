package LeetcodeExplore.RecursionI.HashTable;
//https://leetcode.com/problems/4sum-ii/

import java.util.HashMap;
import java.util.Map;

public class _4544SumII {

    public static void main(String[] args) {
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};


    }
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap();
        int n = A.length, result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i]+B[j];
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = C[i]+D[j];
                if(map.containsKey(-sum)){
                   result +=  map.get(-sum);
                }
            }
        }
        return result;
    }
}
