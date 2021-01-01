package GrokkingCodingPatterns.TopologicalSortGraph;

import java.util.*;

public class AllTasksSchedulingOrders {

    public static void main(String[] args) {

        int[][] prerequisities = {{3, 2}, {3, 0}, {2, 0}, {2, 1}};
        printOrders(4,prerequisities);
    }

    public static void printOrders(int tasks, int[][] prerequisites) {
        if (tasks <= 0) return;

        List<Integer> sortedOrder = new ArrayList<>();

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graphs = new HashMap<>();

        for (int i = 0; i < tasks; i++) {
            graphs.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graphs.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        printAllTopologicalSorts(graphs, inDegree, sources, sortedOrder);
    }

    private static void printAllTopologicalSorts(HashMap<Integer, List<Integer>> graphs, HashMap<Integer, Integer> inDegree,
                                                 Queue<Integer> sources, List<Integer> sortedOrder) {
        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                sourcesForNextCall.remove(vertex);
                List<Integer> children = graphs.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0) {
                        sourcesForNextCall.add(child);
                    }
                }
                printAllTopologicalSorts(graphs, inDegree, sources, sortedOrder);

                sortedOrder.remove(vertex);

                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }
        if (sortedOrder.size() == inDegree.size()) {
            System.out.println(sortedOrder);
        }
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue) {
            clone.add(num);
        }
        return clone;
    }
}
