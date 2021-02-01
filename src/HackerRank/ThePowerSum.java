package HackerRank;
//https://www.hackerrank.com/challenges/the-power-sum/problem

import java.util.*;

/*
Find the number of ways that a given integer, , can be expressed as the sum of the  powers of unique, natural numbers.

For example, if  and , we have to find all combinations of unique squares adding up to . The only solution is .

Function Description

Complete the powerSum function in the editor below. It should return an integer that represents the number of possible combinations.

powerSum has the following parameter(s):

X: the integer to sum to
N: the integer power to raise numbers to
Input Format

The first line contains an integer .
The second line contains an integer .

Constraints

Output Format

Output a single integer, the number of possible combinations caclulated.
 */
public class ThePowerSum {

    public static void main(String[] args) {
        System.out.println(powerSum(100, 2));
    }

    static int count = 0;

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        help(X, N, 0, 1);
        set.forEach(System.out::println);
        return count;
        //return help2(X,N,0,1);
    }

    static List<Integer> list = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();

    static void help(int X, int N, int sum, int index) {
        if (index > X / 2 || sum > X)
            return;
        if (X == sum) {
            //System.out.println();
            Collections.sort(list);
            //list.forEach(System.out::print);
            String st = "";
            for (Integer item : list)
                st = st + "-" + item;
            if (set.contains(st))
                return;
            set.add(st);
            count++;
            return;
        }
        for (int i = index; i <= X / 2; i++) {
            int mult = (int) Math.pow(i, N);
            if (!list.contains(i))
                list.add(i);
            else
                continue;
            help(X, N, sum + mult, index + 1);
            list.remove(list.size() - 1);
        }
    }

    static int help2(int X, int N, int sum1, int index) {
        if (index > X / 2 || sum1 > X)
            return 0;

        if (sum1 == X) {
            return 1;
        }
        int mult = (int) Math.pow(index, N);
        return help2(X, N, sum1 + mult, index + 1) + help2(X, N, sum1, index + 1);
    }
}
