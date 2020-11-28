package LeetcodeExplore.ArrayAndString;

public class _747LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int largest=0;
        int max2=0;
        int indexmax=0;
        for(int i=0;i<nums.length;i++){
            int temp= largest;//0,3,6
            largest = Math.max(largest,nums[i]); //3,6,
            if(nums[i]!=largest){
                max2= Math.max(max2,nums[i]);
            }else{
                max2=temp; //0,3
                indexmax=i;
            }
        }
        return largest>=max2*2 ? indexmax:-1;
    }
}
