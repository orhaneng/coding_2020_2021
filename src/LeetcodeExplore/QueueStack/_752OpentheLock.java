package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/open-the-lock/
//Here's a good read on bidirectional BFS: https://www.geeksforgeeks.org/bidirectional-search/
import java.util.*;

public class _752OpentheLock {
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        openLock(deadends,target);
    }

    public static int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        int depth = -1;
        q.addAll(Arrays.asList("0000"));
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (node.equals(target))
                    return depth;
                if (visited.contains(node))
                    continue;
                visited.add(node);
                q.addAll(getSuccessors(node));
            }
        }
        return -1;
    }

    private static List<String> getSuccessors(String str) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 : str.charAt(i) - '0' - 1) + str.substring(i + 1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 : str.charAt(i) - '0' + 1) + str.substring(i + 1));
        }
        return res;
    }
}
