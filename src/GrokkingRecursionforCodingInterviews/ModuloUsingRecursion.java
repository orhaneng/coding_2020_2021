package GrokkingRecursionforCodingInterviews;

public class ModuloUsingRecursion {

    public static void main(String[] args) {
        System.out.println(mod(14,4));
    }
    static int mod(int dividend, int divisor){
        if(dividend==0)
            return 0;
        if(dividend<divisor)
            return dividend;
        else
            return mod(dividend-divisor,divisor);
    }
}
