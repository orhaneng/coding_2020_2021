package GrokkingCodingPatterns.TopologicalSortGraph;

import java.util.*;

/*
Problem Statement #
Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.

Given a directed graph, find the topological ordering of its vertices.

Example 1:

Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
Output: Following are the two valid topological sorts for the given graph:
1) 3, 2, 0, 1
2) 3, 2, 1, 0

Time Complexity #
In step ‘d’, each vertex will become a source only once and each edge will be accessed and removed once.
Therefore, the time complexity of the above algorithm will be O(V+E),
where ‘V’ is the total number of vertices and ‘E’ is the total number of edges in the graph.

Space Complexity #
The space complexity will be O(V+E), since we are storing all of the edges for each vertex in an adjacency list.


 */
public class TopologicalSort {
    public static void main(String[] args) {

//        int[][] edges = {{4, 2}, {4, 3}, {2, 0}, {2, 1}, {3, 1}};
//        int vertices = 5;
//        int[][] edges = {{6, 4}, {6, 2}, {5, 3}, {5, 4}, {3, 0}, {3, 1}, {3, 2}, {4, 1}};
//        int vertices = 7;
        int[][] edges = {{3, 2}, {3, 0}, {2, 0}, {2, 1}};
        int vertices = 4;

        sort(vertices, edges).forEach(System.out::println);
    }

    public static List<Integer> sort(int vertices, int[][] edges) {

        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0)
            return sortedOrder;

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
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
            List<Integer> children = graph.get(vertex);

            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }
        if (sortedOrder.size() != vertices)
            return new ArrayList<>();

        return sortedOrder;

    }
}
