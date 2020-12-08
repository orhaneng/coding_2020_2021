package LeetcodeExplore.RecursionI;

public class tailRecursion {

    static long fact(int n)
    {
        if (n == 0) return 1;

        return n*fact(n-1);
    }

    // Driver program
    public static void main(String[] args)
    {
        System.out.println(fact(100));
    }
}
