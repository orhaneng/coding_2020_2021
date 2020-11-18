package LeetcodeExplore.RecursionI.ArrayAndString;

public class _283MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes2(arr);
    }
    public static void moveZeroes(int[] nums) {
        int index =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[index];
                nums[index]= nums[i];
                nums[i]= temp;
                index++;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
