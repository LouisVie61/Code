import java.util.*;

public class ComponentInAGraph {
    public static int dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        int count = 1;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(adj, visited, neighbor);
            }
        }
        return count;
    }

    /**
     * cc.
     * @param adj adjacency list
     * @param n number of node
     * @return maxSize + minSize of cc
     */
    public static List<Integer> ccInAGraph(List<List<Integer>> adj, int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int maxSize = 0;
        int minSize = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(adj, visited, i);
                if (size != 1) {
                    maxSize = Math.max(maxSize, size);
                    minSize = Math.min(minSize, size);
                }
            }
        }

        list.add(minSize);
        list.add(maxSize);
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        Map<Integer, Integer> nodeMapping = new HashMap<>();
        int nodeCount = 0;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (!nodeMapping.containsKey(u)) {
                nodeMapping.put(u, nodeCount++);
                adj.add(new ArrayList<>());
            }
            if (!nodeMapping.containsKey(v)) {
                nodeMapping.put(v, nodeCount++);
                adj.add(new ArrayList<>());
            }

            int mappedU = nodeMapping.get(u);
            int mappedV = nodeMapping.get(v);

            adj.get(mappedU).add(mappedV);
            adj.get(mappedV).add(mappedU);
        }

        List<Integer> result = ccInAGraph(adj, nodeCount);
        System.out.print(result);
    }
}
