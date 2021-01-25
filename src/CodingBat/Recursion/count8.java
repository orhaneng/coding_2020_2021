package CodingBat.Recursion;

//https://codingbat.com/prob/p192383

/*
Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
count8(8) → 1
count8(818) → 2
count8(8818) → 4

 */
public class count8 {
    public static void main(String[] args) {
        System.out.println(count8(88888));
    }

    public static int count8(int n) {
        return help(n, false);
    }

    public static int help(int n, boolean flag) {
        int count = 0;
        if (n < 8)
            return 0;
        if (n % 10 == 8) {
            if (flag)
                count = 2;
            else {
                flag = true;
                count = 1;
            }
        } else {
            flag = false;
        }

        return help(n / 10, flag) + count;
    }

    public int count82(int n) {
        if (n < 8)
            return 0;
        if (n % 10 == 8) {
            if ((n / 10) % 10 == 8)
                return count8(n / 10) + 2;
            else {
                return count8(n / 10) + 1;
            }
        }
        return count8(n / 10);
    }


}
