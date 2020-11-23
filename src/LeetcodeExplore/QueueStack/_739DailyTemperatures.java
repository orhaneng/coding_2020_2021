package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/daily-temperatures/

import java.util.Arrays;
import java.util.Stack;

public class _739DailyTemperatures {
    public static void main(String[] args) {

        Arrays.stream(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).forEach(System.out::println);
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }
}
