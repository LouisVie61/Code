import java.util.*;

public class KruskalAlgorithm {
    // implement UnionFind to check cycle existence
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    class UnionFind {
        private int[] parent, rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }

        public void union(int u, int v) {
            int rootU = parent[u];
            int rootV = parent[v];

            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootU] = rootV;
                    rank[rootV]++;
                }
            }
        }
    }

    public int findMST(int vertices, List<Edge> edges) {
        Collections.sort(edges);

        UnionFind uf = new UnionFind(vertices);
        List<Edge> mstEdges = new ArrayList<>();
        int mst = 0;

        for (Edge edge : edges) {
            if (uf.find(edge.src) != uf.find(edge.dest)) {
                uf.union(edge.src, edge.dest);
                mstEdges.add(edge);
                mst += edge.weight;
            }
        }

        System.out.println("Edges in MST:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }

        return mst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KruskalAlgorithm ka = new KruskalAlgorithm();

        int vertices = sc.nextInt();
        int edgeCount = sc.nextInt();

        List<Edge> edges1 = new ArrayList<>();

        for (int i = 0; i < edgeCount; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();

            if (u < 1 || u > vertices || v < 1 || v > vertices) {
                System.out.println("Failed");
                return;
            }

            edges1.add(ka.new Edge(u - 1, v - 1, weight));
        }

        System.out.println(ka.findMST(vertices, edges1));
    }
}
