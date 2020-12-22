package GrokkingCodingPatterns.FastSlowPointers;

//https://leetcode.com/problems/happy-number/submissions/

/*
Time Complexity #
The time complexity of the algorithm is difficult to determine. However we know the fact that all
unhappy numbers eventually get stuck in the cycle: 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4

This sequence behavior tells us two things:

If the number NN is less than or equal to 1000, then we reach the cycle or ‘1’ in at most 1001 steps.
For N > 1000N>1000, suppose the number has ‘M’ digits and the next number is ‘N1’. From the above Wikipedia link, we know that the sum of the squares of the digits of ‘N’ is at most 9^2M9
​2
​​ M, or 81M81M (this will happen when all digits of ‘N’ are ‘9’).
This means:

N1 < 81MN1<81M
As we know M = log(N+1)M=log(N+1)
Therefore: N1 < 81 * log(N+1)N1<81∗log(N+1) => N1 = O(logN)N1=O(logN)
This concludes that the above algorithm will have a time complexity of O(logN)O(logN).

Space Complexity #
The algorithm runs in constant space O(1)O(1).
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(find(23));
    }


    public static boolean find(int num) {
        int slow = num, fast = num;
        do{
            slow = findsquare(slow);
            fast = findsquare(findsquare(fast));
        }while (slow!=fast);
        return slow==1;
    }

    public static int findsquare(int num) {
        int sum = 0, tmp;
        while (num > 0) {
            tmp = num % 10;
            sum += tmp * tmp;
            num /= 10;
        }
        return sum;
    }
/*    public static boolean find(int num) {
        HashSet<Integer> set = new HashSet<>();
        int n = num;
        while (true) {
            int tempsum = 0;
            while (n> 0) {
                int remain = n % 10;
                tempsum += remain * remain;
                n = n / 10;
            }
            if (tempsum == 1) return true;
            else if (set.contains(tempsum)) {
                return false;
            }
            set.add(tempsum);
            n = tempsum;
        }
    }*/
}
