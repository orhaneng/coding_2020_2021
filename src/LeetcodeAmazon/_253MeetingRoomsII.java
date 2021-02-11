package LeetcodeAmazon;

//https://leetcode.com/problems/meeting-rooms-ii/

import java.util.Arrays;
import java.util.PriorityQueue;

public class _253MeetingRoomsII {

    //TIME O(NLOGN)
    //SPACE O(N)

    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i=0;i<intervals.length;i++){
            starts[i]=intervals[i][0];
            ends[i]=intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int count=0;
        int endindex=0;
        for(int i=0;i<intervals.length;i++){
            if(starts[i]<ends[endindex])
                count++;
            else
                endindex++;
        }



        return count;


    }
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        if(points.length==0||K==0)
            return res;
        PriorityQueue<int[]> maxHeap= new PriorityQueue<int[]>((a,b)->((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1])));

        for(int[] point:points){
            maxHeap.add(point);
            if(maxHeap.size()>K)
                maxHeap.poll();
        }
        int index=0;
        while(!maxHeap.isEmpty()){
            res[index]=maxHeap.poll();
            index++;
        }
        return res;
    }

}
