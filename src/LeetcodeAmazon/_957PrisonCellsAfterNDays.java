package LeetcodeAmazon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _957PrisonCellsAfterNDays {

    public static void main(String[] args) {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int n = 7;

        Arrays.stream(prisonAfterNDays(cells, n)).forEach(System.out::println);
    }

    public static int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> set = new HashSet<>();

        int count = 0;
        boolean cycle = false;
        for (int i = 0; i < n; i++) {
            int[] next = nextDay(cells);
            String pattern = String.valueOf(next);
            if (!set.contains(pattern)) {
                set.add(pattern);
                count++;
                cells = next;
            } else {
                cycle = true;
                break;
            }
        }
        System.out.println(count);

        if (cycle) {
            n %= count;
            for (int i = 0; i < n; i++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    public static int[] nextDay(int[] arr) {
        int[] newarr = new int[arr.length];
        for (int i = 1; i < arr.length - 1; i++) {
            newarr[i] = arr[i - 1] == arr[i + 1] ? 1 : 0;
        }
        return newarr;
    }
/*
 TIME LIMIT EXCEED
 public static int[] prisonAfterNDays(int[] cells, int n) {
        int size = cells.length;

        for (int j = 0; j < n; j++) {
            for (int i:cells) {
                System.out.print(i+"-");
            }
            System.out.println();
            int[] temp = new int[size];
            for (int i = 1; i < size - 1; i++) {
                if (cells[i - 1] == cells[i + 1])
                    temp[i] = 1;
                else
                    temp[i] = 0;
            }
            cells = Arrays.copyOf(temp,size);
        }
        return cells;
    }*/
}
