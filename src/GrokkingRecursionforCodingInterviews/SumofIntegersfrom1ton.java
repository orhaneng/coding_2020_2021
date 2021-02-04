package GrokkingRecursionforCodingInterviews;

public class SumofIntegersfrom1ton {
    public static void main(String[] args) {
        System.out.println(sumAll(5));
    }
    static int  sumAll(int n){
        if(n<=1)
            return 1;
        return n+sumAll(n-1);
    }

}
