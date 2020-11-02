package LeetcodeExplore.Arrays101;
//https://leetcode.com/problems/squares-of-a-sorted-array/

import java.util.Arrays;

public class _977SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(i->i*i).sorted().toArray();
    }
}
