package LeetcodeExplore.RecursionI;
//https://leetcode.com/problems/fibonacci-number/
/*

TIME O(N)
SPACE O(N)
 */
public class _509FibonacciNumber {
    Integer[] cache = new Integer[31];

    public int fib(int N) {
        if(N<=1){
            return N;
        }
        cache[0]=0;
        cache[1]=1;
        return help(N);
    }

    public int help(int N) {
        if(cache[N]!=null){
            return cache[N];
        }
        cache[N] = help(N-1)+help(N-2);
        return help(N);
    }
}
