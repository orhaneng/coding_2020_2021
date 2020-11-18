package LeetcodeExplore.RecursionI.Arrays101;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.Arrays;

public class _1051HeightChecker {

    public static void main(String[] args) {
        int[] arr = {1,1,4,2,1,3};

        //System.out.println(Arrays.stream(Arrays.asList(arr)).filter(value -> Arrays.asList(arr).contains(value)).count());

    }
    public static int heightChecker(int[] heights) {
        int[] clone = heights.clone();
        Arrays.sort(clone);
        int count=0;
        for(int i=0;i<clone.length;i++){
            if(clone[i]!= heights[i]) count++;
        }
        return count;
    }


}
