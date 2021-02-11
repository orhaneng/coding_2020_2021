package LeetcodeAmazon;


//https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

public class _994RottingOranges {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<int[]>();
        int min = -1;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        if (count == 0)
            return 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            min++;
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                for (int[] dir : dirs) {
                    int x = arr[0] + dir[0];
                    int y = arr[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        grid[x][y] = 2;
                        count--;
                    }
                }
            }
        }

        return count != 0 ? -1 : min;
    }
}
