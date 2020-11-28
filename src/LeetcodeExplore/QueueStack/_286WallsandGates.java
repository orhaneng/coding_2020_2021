package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/walls-and-gates/

import java.util.LinkedList;
import java.util.Queue;

public class _286WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = m == 0 ? 0 : rooms[0].length;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int[] dir : dirs) {
                int X = cur[0] + dir[0];
                int Y = cur[1] + dir[1];
                if (X < 0 || Y < 0 || X >= m || Y >= n || rooms[X][Y] != Integer.MAX_VALUE) continue;
                rooms[X][Y] = rooms[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{X, Y});
            }
        }
    }


}
