package GrokkingRecursionforCodingInterviews;

import java.util.List;

public class Depth_First_Search_in_Graphs {
    static class edge {//This class is to create an edge between two nodes
        int src, dst;

        edge() {
        }

        edge(int s, int d) {//Copy constructor for the edge class
            src = s;
            dst = d;
        }
    }

    static class graph {
        int nodes;
        List<edge> edges;

        public graph(int n, List<edge> e) {
            nodes = n;
            for (int i = 0; i < e.size(); i++) {
                edges.add(e.get(i));
            }
        }


        void DFS(int v, int[] visited) {
            if (visited[v] == 1) {
                return;
            } else {

                System.out.println(v);

                for (int i = 0; i < edges.size(); i++) {
                    if (edges.get(i).src == v) {
                        int dest = edges.get(i).dst;
                        if (visited[dest] == 0)
                            DFS(dest, visited);
                    }
                }
            }
            visited[v] = 1;
        }
    }
}
