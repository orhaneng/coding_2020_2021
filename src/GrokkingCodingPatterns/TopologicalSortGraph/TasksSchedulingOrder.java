package GrokkingCodingPatterns.TopologicalSortGraph;

import java.util.*;

public class TasksSchedulingOrder {
    public static List<Integer> findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) return new ArrayList<>();

        List<Integer> sortedOrder = new ArrayList<>();

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graphs = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graphs.put(i, new ArrayList<>());
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
        if(sortedOrder.size()!= numCourses)
            return new ArrayList<>();
        return sortedOrder;
    }
}
