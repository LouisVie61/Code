import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static int findMSTWithPrim(int vertices, List<Edge> edges, int startNode) {
        // convert to Adjacency List
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adj.get(edge.src).add(edge);
            adj.get(edge.dest).add(new Edge(edge.dest, edge.src, edge.weight));
        }

        // using min heap
        // personally, it's similar to BFS at some point
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] inMST = new boolean[vertices];
        int mst = 0;

        inMST[startNode] = true;
        for (Edge edge : adj.get(startNode)) {
            pq.add(edge);
        }

        while(!pq.isEmpty()) {
            Edge currnentEdge = pq.poll();
            int u = currnentEdge.src;
            int v = currnentEdge.dest;
            int weight = currnentEdge.weight;

            if (inMST[v]) {
                continue;
            }

            inMST[v] = true;
            mst += weight;

            for (Edge nextEdge : adj.get(v)) {
                if (!inMST[nextEdge.dest]) {
                    pq.add(nextEdge);
                }
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edgeCount = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < edgeCount; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();

            edges.add(new Edge(u - 1, v - 1, weight));
        }

        int startNode = sc.nextInt() - 1;

        System.out.println(findMSTWithPrim(vertices, edges, startNode));
    }
}
