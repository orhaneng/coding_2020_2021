package GrokkingRecursionforCodingInterviews;

public class Findthegreatestcommondivisor {
    public static void main(String[] args) {
        System.out.println(gcd(24, 18));
    }

//    static int gcd(int num1, int num2) {
//        return help(num1, num2, num1 > num2 ? num2 : num1);
//    }

    static int help(int num1, int num2, int k) {
        if (k == 0)
            return k;

        if (num1 % k == 0 && num2 % k == 0) {
            return k;
        }

        return help(num1, num2, --k);

    }

    static int gcd(int num1, int num2) {
        if (num1 == num2)
            return num1;
        else if (num1 > num2) {
            return gcd(num1 - num2, num1);
        } else {
            return gcd(num1, num2 - num1);
        }
    }
}
