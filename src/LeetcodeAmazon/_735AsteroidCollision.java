package LeetcodeAmazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class _735AsteroidCollision {

    public static void main(String[] args) {
        Arrays.stream(asteroidCollision(new int[]{5,10,-5})).forEach(System.out::println);
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<Integer>();

        for (int item : asteroids) {
            stack.push(item);
            while (!stack.isEmpty() && stack.size() > 1) {
                int right = stack.pop();
                int left = stack.pop();
                if (left > 0 && right < 0) {
                    if (Math.abs(left) < Math.abs(right)) {
                        stack.push(right);
                    } else if (Math.abs(left) > Math.abs(right)) {
                        stack.push(left);
                    }
                    if (Math.abs(left) == Math.abs(right)) {

                        break;
                    }
                } else {
                    stack.push(left);
                    stack.push(right);
                    break;
                }
            }
        }

        int[] res = new int[stack.size()];
        while (!stack.isEmpty()) {
            res[stack.size()-1] = stack.pop();
        }

        return res;
    }

}

