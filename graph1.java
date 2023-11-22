import java.util.*;

public class graph1 {
    static class Edge {
        int source;
        int deti;

        public Edge(int s, int d) {
            this.source = s;
            this.deti = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph, v);

        if (graph[2] != null) {
            for (int i = 0; i < graph[2].size(); i++) {
                Edge e = graph[2].get(i);
                System.out.println(e.deti);
            }
        } else {
            System.out.println("graph[2] is null");
        }
    }
}
