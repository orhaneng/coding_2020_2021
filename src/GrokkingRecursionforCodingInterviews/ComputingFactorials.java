package GrokkingRecursionforCodingInterviews;

public class ComputingFactorials {

    public static void main(String[] args) {
        System.out.println(factorial(6));
    }
    static double factorial(int n){
        if(n==0)
            return 1;
        return n*factorial(n-1);
    }

}
