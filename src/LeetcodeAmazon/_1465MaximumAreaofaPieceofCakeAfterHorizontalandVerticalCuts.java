package LeetcodeAmazon;

//https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

import java.util.Arrays;
/*
TIME O(LOG(H+W))
SPACE O(N)
 */
public class _1465MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            long hor = getMax(horizontalCuts, h);
            long ver = getMax(verticalCuts, w);
            return (int) ((hor * ver) % (Math.pow(10, 9) + 7));
        }

        public long getMax(int[] arr, int size) {
            Arrays.sort(arr);
            int prev = 0;
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(arr[i] - prev, max);
                prev = arr[i];
            }
            max = Math.max(size - arr[arr.length - 1], max);
            return max;
        }

    }
}
