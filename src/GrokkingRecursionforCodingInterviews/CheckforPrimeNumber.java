package GrokkingRecursionforCodingInterviews;

public class CheckforPrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(7,7/2));
    }
    static boolean isPrime(int n, int i){
        if(i==1)
            return true;
        else if(n%i==0)
            return false;

        return isPrime(n,i-1);
    }
}
