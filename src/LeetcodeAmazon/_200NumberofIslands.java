package LeetcodeAmazon;

//https://leetcode.com/problems/number-of-islands/

import java.util.LinkedList;
import java.util.Queue;

public class _200NumberofIslands {


    class Solution {

        //TIME O(M*N)
        //SPACE O(M*N)
        public int numIslands(char[][] grid) {
            if (grid.length == 0)
                return 0;
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        helper(grid, i, j);
                    }
                }
            }
            return count;
        }

        public void helper(char[][] grid, int x, int y) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0')
                return;
            grid[x][y] = '0';
            helper(grid, x + 1, y);
            helper(grid, x, y + 1);
            helper(grid, x - 1, y);
            helper(grid, x, y - 1);
        }

        public int numIslands2(char[][] grid) {
            if (grid.length == 0)
                return 0;
            int count = 0;
            int[][] arr = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        grid[i][j] = '0';
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] item = queue.poll();
                            for (int k = 0; k < arr.length; k++) {
                                int x = item[0] + arr[k][0];
                                int y = item[1] + arr[k][1];
                                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
                                    grid[x][y] = '0';
                                    queue.add(new int[]{x, y});
                                }
                            }
                        }

                    }
                }
            }
            return count;
        }
    }


}


