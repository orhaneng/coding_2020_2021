package LeetcodeAmazon;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class _353DesignSnakeGame {

    public static void main(String[] args) {

        int[][] foods = {{1, 2}, {0, 1}};
        SnakeGame snakeGame = new SnakeGame(3, 2, foods);
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("U"));
    }

}

class SnakeGame {
    Set<Integer> set;
    Deque<Integer> body;
    int score;
    int[][] food;
    int foodindex;
    int width;
    int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        set.add(0);
        body = new LinkedList<>();
        body.offer(0);
        foodindex = 0;
    }

    public int move(String direction) {
        if (score == -1)
            return -1;

        int rowhead = body.peekFirst() / width;
        int colhead = body.peekFirst() % width;

        switch (direction) {
            case "U":
                rowhead--;
                break;
            case "D":
                rowhead++;
                break;
            case "L":
                colhead--;
                break;
            case "R":
                colhead++;
                break;
        }

        int head = rowhead * width + colhead;

        set.remove(body.peekLast());

        if (rowhead < 0 || rowhead == height || colhead == width || colhead < 0 || set.contains(head)) {
            return score = -1;
        }

        set.add(head);

        body.offerFirst(head);

        if(foodindex<food.length && rowhead == food[foodindex][0] && colhead == food[foodindex][1]){
            set.add(body.peekLast());
            foodindex++;
            return ++score;
        }

        body.removeLast();
        return score;

    }
}

//class SnakeGame {
//
//    /** Initialize your data structure here.
//     @param width - screen width
//     @param height - screen height
//     @param food - A list of food positions
//     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
//    int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
//    int[] pos;
//    int[][] food;
//    int index=0;
//    int width;
//    int height;
//    int score=0;
//    public SnakeGame(int width, int height, int[][] food) {
//        pos = new int[]{0,0};
//        this.food = food;
//        this.width = width;
//        this.height = height;
//    }
//
//    /** Moves the snake.
//     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
//     @return The game's score after the move. Return -1 if game over.
//     Game over when snake crosses the screen boundary or bites its body. */
//    public int move(String direction) {
//        if(index>=food.length || pos[0]<0 || pos[1]<0||pos[1]>=width||pos[0]>=height)
//            return -1;
//        if(direction.equals("U")){
//            pos[0] = pos[0]+dirs[0][0];
//            pos[1] = pos[1]+dirs[0][1];
//        }else if(direction.equals("L")){
//            pos[0] = pos[0]+dirs[1][0];
//            pos[1] = pos[1]+dirs[1][1];
//        }else if(direction.equals("R")){
//            pos[0] = pos[0]+dirs[2][0];
//            pos[1] = pos[1]+dirs[2][1];
//        }else if(direction.equals("D")){
//            pos[0] = pos[0]+dirs[3][0];
//            pos[1] = pos[1]+dirs[3][1];
//        }
//        if(food[index][0]==pos[0] &&food[index][1]==pos[1] ){
//            score++;
//            index++;
//        }
//
//        return score;
//    }
//}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */