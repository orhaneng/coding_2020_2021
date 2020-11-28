package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/keys-and-rooms/

import java.util.*;

public class _841KeysandRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<Integer>(new ArrayList<>(Arrays.asList(1, 3))));
        rooms.add(new ArrayList<Integer>(new ArrayList<>(Arrays.asList(3, 0, 1))));
        rooms.add(new ArrayList<Integer>(new ArrayList<>(Arrays.asList(2))));
        rooms.add(new ArrayList<Integer>(new ArrayList<>(Arrays.asList(0))));
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        while (!stack.isEmpty()) {
            Integer key = stack.pop();
            for (int i : rooms.get(key)) {
                if(!set.contains(i)){
                    set.add(i);
                    stack.add(i);
                    if(rooms.size()==set.size()) return true;
                }
            }
        }
        return rooms.size()==set.size();
    }
}
