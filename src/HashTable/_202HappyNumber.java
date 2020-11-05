package HashTable;

import java.util.HashSet;
import java.util.Set;

public class _202HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int remain=0;
        int sum=0;
        while(set.add(n)){ //19,
            sum=0;
            while(n>0){
                remain = n%10;
                sum += remain*remain;
                n=n/10;
            }
            if(sum==1){
                return true;
            }
            n=sum;
        }
        return false;
    }


}
