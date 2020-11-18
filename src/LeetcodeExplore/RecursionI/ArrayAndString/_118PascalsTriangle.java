package LeetcodeExplore.RecursionI.ArrayAndString;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class _118PascalsTriangle {
    public static void main(String[] args) {
        generate(5).stream().forEach(System.out::println);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(0,1);
            for(int j=1;j<i;j++){
                list.set(j,list.get(j)+list.get(j+1));
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
