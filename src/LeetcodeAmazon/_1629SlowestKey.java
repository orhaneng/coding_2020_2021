package LeetcodeAmazon;

//https://leetcode.com/problems/slowest-key/

public class _1629SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char longest = keysPressed.charAt(0);
        int duration = releaseTimes[0];
        for(int i=1;i<releaseTimes.length;i++){
            int diff= releaseTimes[i]-releaseTimes[i-1];
            if(duration<diff || (duration==diff &&longest-'a'<keysPressed.charAt(i)-'a')){
                longest = keysPressed.charAt(i);
                duration= diff;
            }
        }
        return longest;
    }
}
