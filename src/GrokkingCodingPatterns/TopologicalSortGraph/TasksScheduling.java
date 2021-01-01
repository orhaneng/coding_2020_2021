package GrokkingCodingPatterns.TopologicalSortGraph;

//https://leetcode.com/problems/course-schedule/

import java.util.*;

public class TasksScheduling {

    /*

    Problem Statement #
There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before
it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.

Example 1:

Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
Output: true
Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs to finish
before '2' can be scheduled. A possible sceduling of tasks is: [0, 1, 2]


    Time complexity #
In step ‘d’, each task can become a source only once and each edge (prerequisite) will be accessed and removed once.
Therefore, the time complexity of the above algorithm will be O(V+E)O(V+E), where ‘V’ is the total number of tasks and ‘E’
is the total number of prerequisites.

Space complexity #
The space complexity will be O(V+E)O(V+E), ), since we are storing all of the prerequisites for each task in an adjacency list.

     */
    public static void main(String[] args) {
        int[][] prerequisities = {{0, 2}, {1, 2}, {2, 0}};
        System.out.println(canFinish(3, prerequisities));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) return false;

        List<Integer> sortedOrder = new ArrayList<>();

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graphs = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graphs.put(i, new ArrayList<Integer>());
            inDegree.put(i, 0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graphs.get(parent).add(child);
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graphs.get(vertex);

            for (Integer child : children) {
                inDegree.put(child, inDegree.getOrDefault(child, 0) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }
        return sortedOrder.size() == numCourses;
    }
}
