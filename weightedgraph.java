import java.util.*;

public class weightedgraph {
    static class Edge {
        int source;
        int deti;
        int wei;

        public Edge(int s, int d, int w) {
            this.wei = w;
            this.source = s;
            this.deti = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 6));
        graph[1].add(new Edge(1, 3, 5));
        graph[2].add(new Edge(2, 0, 7));
        graph[2].add(new Edge(2, 1, 2));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 10));
        graph[3].add(new Edge(3, 2, 15));
    }

    public static void bfs(ArrayList<Edge>[] graph, int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v];

        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                System.out.println(curr);
                visited[curr] = true;
            }
            for (Edge e : graph[curr]) {
                q.add(e.deti);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        System.out.println(curr);
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.deti] == false) {
                dfs(graph, e.deti, visited);
            }

        }
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        boolean vis[] = new boolean[v];

        createGraph(graph, v); // Call createGraph method to initialize the graph

        // Access and print elements of graph[2]
        if (graph[2] != null) {
            for (int i = 0; i < graph[2].size(); i++) {
                Edge e = graph[2].get(i);
                System.out.println(e.deti + " " + e.wei);
            }
        } else {
            System.out.println("graph[2] is null");
        }

        bfs(graph, v);
        dfs(graph, 0, vis);
    }
}
