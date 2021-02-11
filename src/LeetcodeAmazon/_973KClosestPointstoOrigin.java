package LeetcodeAmazon;
//https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.Arrays;
import java.util.PriorityQueue;

//TIME O(NLOGN)
//SPACE O(N)
public class _973KClosestPointstoOrigin {
    class Solution {
    /*
    class item{
        int distance;
        int[] point;
        public item(int distance, int[] point){
            this.distance= distance;
            this.point= point;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        if(points.length==0||K==0)
            return res;
        PriorityQueue<item> maxHeap= new PriorityQueue<item>((a,b)->b.distance-a.distance);

        for(int[] point:points){
            int distance= point[0]*point[0]+point[1]*point[1];
            maxHeap.add(new item(distance, point));
            if(maxHeap.size()>K)
                maxHeap.poll();
        }
        int index=0;
        while(!maxHeap.isEmpty()){
            res[index]=maxHeap.poll().point;
            index++;
        }
        return res;
    }
    */

//        public int[][] kClosest(int[][] points, int K) {
//            int[][] res = new int[K][2];
//            if (points.length == 0 || K == 0)
//                return res;
//            PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>
//                    ((a, b) -> ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])));
//            for (int[] point : points) {
//                maxHeap.add(point);
//                if (maxHeap.size() > K)
//                    maxHeap.poll();
//            }
//            int index = 0;
//            while (!maxHeap.isEmpty()) {
//                res[index] = maxHeap.poll();
//                index++;
//            }
//            return res;
//        }
                public int[][] kClosest(int[][] points, int K) {
                    Arrays.sort(points,((a, b) -> ((a[0] * a[0] + a[1] * a[1])-(b[0] * b[0] + b[1] * b[1]))));
                    int[][] res = new int[K][2];
                    for (int i = 0; i <K ; i++) {
                        res[i]= points[i];
                    }
                    return res;
                }

    }
}
