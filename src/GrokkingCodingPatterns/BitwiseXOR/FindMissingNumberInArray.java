package GrokkingCodingPatterns.BitwiseXOR;

public class FindMissingNumberInArray {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{1, 5, 2, 6, 4}));
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;

        int x1 = 1;
        for (int i = 2; i <= n; i++) {
            System.out.println(x1 + "^" + i + "=" + (x1 ^ i));
            x1 = x1 ^ i;
        }
        System.out.println("x1=" + x1);
        int x2 = arr[0];
        System.out.println();

        for (int i = 1; i < n - 1; i++) {
            System.out.println(x2 + "^" + arr[i] + "=" + (x2 ^ arr[i]));
            x2 = x2 ^ arr[i];
        }
        return x1 ^ x2;
    }
}
