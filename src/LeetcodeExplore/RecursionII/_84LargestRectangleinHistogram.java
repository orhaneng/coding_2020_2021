package LeetcodeExplore.RecursionII;
//https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/?currentPage=1&orderBy=hot&query=

import java.util.Stack;

public class _84LargestRectangleinHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int h = i == len ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                continue;
            }
            int he = stack.pop();
            maxArea = Math.max(maxArea, heights[he] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
        }
        return maxArea;
    }
}
