package LeetcodeAmazon;

//https://leetcode.com/problems/maximum-units-on-a-truck/

import java.util.Arrays;

public class _1710MaximumUnitsonaTruck {

    public static void main(String[] args) {
        int[][] boxes = {{1,3},{2,2},{3,1}};
        System.out.println(maximumUnits(boxes,4));
    }
    public  static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)-> b[1]-a[1]);
        int totalunits =0;
        for(int i=0;i<boxTypes.length;i++){
            int numberbox = boxTypes[i][0];
            int units= boxTypes[i][1];
            int boxcount= Math.min(numberbox,truckSize);
            totalunits +=boxcount*units;
            truckSize -=boxcount;
            if(truckSize<=0)
                break;
        }
        return totalunits;
    }
}
