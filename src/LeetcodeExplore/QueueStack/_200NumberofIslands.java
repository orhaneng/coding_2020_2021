package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/number-of-islands/

import java.util.*;
import java.util.stream.Collectors;

public class _200NumberofIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands2(grid));

    }

    public static int numIslands2(char[][] grid) {
        if(grid.length == 0) return 0;
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1') {
                    help(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void help(char[][] grid, int x, int y){
        if(x<0 || x>=grid.length || y<0 || y >= grid[0].length || grid[x][y]!='1')
            return;
        grid[x][y] = '0';
        help(grid, x+1, y);
        help(grid, x-1, y);
        help(grid, x, y+1);
        help(grid, x, y-1);

    }

    public static int numIslands(char[][] grid) {

        if (grid.length == 0) return 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    bfs(grid, visited, queue);
                }
            }
        }
        return count;
    }

    public static void bfs(char[][] grid, boolean[][] visited, Queue<int[]> queue) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] item = queue.poll();

            for (int[] dir : dirs) {
                int x = item[0] + dir[0];
                int y = item[1] + dir[1];

                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || grid[x][y] == '0') {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
                Iterable<Character> stack = new Stack<>();
            }
        }
    }
}
