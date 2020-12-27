package GrokkingCodingPatterns.BitwiseXOR;

//https://leetcode.com/problems/complement-of-base-10-integer/


public class ComplementofBase10Number {

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(8));
    }
    public static int bitwiseComplement(int N) {

        if(N ==0) return 1;
        int bitcount = 0;
        int n = N;

        while(n>0){
            bitcount++;
            n = n >> 1;
        }


        int all_bits_set = (int) Math.pow(2, bitcount)-1;

        return N ^ all_bits_set;
    }
}
