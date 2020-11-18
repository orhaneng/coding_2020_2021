package LeetcodeExplore.RecursionI.ArrayAndString;
//https://leetcode.com/problems/pascals-triangle-ii/

import java.util.ArrayList;
import java.util.List;

public class _119PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            list.add(0,1);
            for(int j = 1; j < i ; j++) {
                list.set(j, list.get(j) + list.get(j+1));
            }
        }
        return list;
    }
}
