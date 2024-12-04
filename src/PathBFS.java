import java.util.*;

public class PathBFS {
    // Adjacency list
    private static List<List<Integer>> edgeListToAdjacencyList(int n, List<int[]> edgeList) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }

    // Apply BFS with p

    /**
     * test.
     *
     * @param n is number of node
     * @param startNode begining node
     * @param adjNode   adjacency list
     * @return an array contain length
     */
    public static int[] pathsAvailable(int n, int startNode, int[][] adjNode) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int[] distances = new int[n];

        int[] ans = new int[n];

        queue.add(startNode);
        visited[startNode] = true;
        distances[startNode] = 0;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            for (int nextNode : adjNode[curNode]) {
                if (!queue.contains(nextNode) && !visited[nextNode]) {
                    distances[nextNode] = distances[curNode] + 6;
                    visited[nextNode] = true;
                    queue.add(nextNode);
                    ans[nextNode] = distances[nextNode];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of test cases
        int t = scanner.nextInt();

        while (t-- > 0) {
            // Input: number of nodes and edges
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            // Input: list of edges
            List<int[]> edgeList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1; // Convert 1-based to 0-based
                int v = scanner.nextInt() - 1; // Convert 1-based to 0-based
                edgeList.add(new int[]{u, v});
            }

            // Input: start node
            int startNode = scanner.nextInt() - 1; // Convert 1-based to 0-based

            // Convert edge list to adjacency list
            List<List<Integer>> adjList = edgeListToAdjacencyList(n, edgeList);

            // Convert adjacency list to 2D array
            int[][] adjNode = new int[n][];
            for (int i = 0; i < n; i++) {
                adjNode[i] = adjList.get(i).stream().mapToInt(Integer::intValue).toArray();
            }

            // Compute shortest paths using BFS
            int[] result = pathsAvailable(n, startNode, adjNode);

            // Output results for the current test case
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i != startNode) {
                    output.append(result[i] == 0 ? -1 : result[i]).append(" ");
                }
            }

            System.out.println(output.toString().trim());
        }

        scanner.close();
    }
}
