package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/flood-fill/

public class _733FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(image, 1, 1, 2);

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) return image;
        help(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public static void help(int[][] image, int x, int y, int newColor, int oldColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] == oldColor || image[x][y] == newColor) {
            return;
        }
        image[x][y] = newColor;
        help(image, x - 1, y, newColor, oldColor);
        help(image, x + 1, y, newColor, oldColor);
        help(image, x, y - 1, newColor, oldColor);
        help(image, x, y + 1, newColor, oldColor);
    }
}
