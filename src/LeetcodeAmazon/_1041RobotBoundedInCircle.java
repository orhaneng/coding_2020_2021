package LeetcodeAmazon;

//https://leetcode.com/problems/robot-bounded-in-circle/

import com.sun.org.apache.regexp.internal.RE;

public class _1041RobotBoundedInCircle {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGGLGLGLGG"));
    }

    public static boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        char direc = 'N';


        for (char ch : instructions.toCharArray()) {

            if (ch == 'G') {
                if (direc == 'N')
                    y--;
                else if (direc == 'W')
                    x--;
                else if (direc == 'S')
                    y++;
                else if (direc == 'E')
                    x++;
            }
            if (ch == 'L') {
                if (direc == 'N')
                    direc = 'W';
                else if (direc == 'W')
                    direc = 'S';
                else if (direc == 'S')
                    direc = 'E';
                else
                    direc = 'N';
            }
            if (ch == 'R') {
                if (direc == 'N')
                    direc = 'E';
                else if (direc == 'W')
                    direc = 'N';
                else if (direc == 'S')
                    direc = 'W';
                else if (direc == 'E')
                    direc = 'S';
            }

        }

        if (x == 0 && y == 0)
            return true;
        if (direc == 'N')
            return false;

        return true;
    }




/*    public  static boolean isRobotBounded(String instructions) {
        if (instructions.length() == 0)
            return false;
        int x = 0;
        int y = 0;  // initial points of the robot
        String directions = "North"; // initial direction of robot
        for (char ch: instructions.toCharArray()) {
            if (ch == 'G') {
                if (directions.equals("North"))
                    y += 1;
                else if (directions.equals("South"))
                    y -= 1;
                else if(directions.equals("East"))
                    x += 1;
                else
                    x -= 1;
            }
            else if (ch == 'L') {
                if (directions.equals("North"))
                    directions = "West";
                else if (directions.equals("West"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "East";
                else directions = "North";
            }
            else if (ch == 'R') {
                if (directions.equals("North"))
                    directions = "East";
                else if (directions.equals("East"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "West";
                else directions = "North";
            }
        }
        if (x == 0 && y == 0)
            return true;
        if (directions.equals("North"))
            return false;
        return true;
    }*/


}
