import java.util.*;

public class NumberOfCells {
    // Apply BFS
    public static int cntCells (int[][] grid, int startRow, int startCol) {
        int[][] directions = {
                {-1,  0}, // Up
                { 1,  0}, // Down
                { 0, -1}, // Left
                { 0,  1}, // Right
                {-1, -1}, // Top-left
                {-1,  1}, // Top-right
                { 1, -1}, // Bottom-left
                { 1,  1}  // Bottom-right
        };

        if (grid[startRow][startCol] == 0) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int cntCell = 1;

        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();

            for (int[] direction : directions) {
                int newX = curPoint[0] + direction[0];
                int newY = curPoint[1] + direction[1];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                    && grid[newX][newY] == 1 && !visited[newX][newY]) {

                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                    cntCell++;
                }
            }
        }

        return cntCell;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] grid = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = cntCells(grid, i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);
    }
}
