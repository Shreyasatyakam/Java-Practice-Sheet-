import java.util.*;

public class RatInMaze {

    public static void solveMaze(int[][] maze, int n, int x, int y, boolean[][] visited, String path, List<String> result) {
        if (x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }

        // Directions: U, D, L, R
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char[] dir = {'U', 'D', 'L', 'R'};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < n && newY < n &&
                maze[newX][newY] == 1 && !visited[newX][newY]) {

                visited[newX][newY] = true;
                solveMaze(maze, n, newX, newY, visited, path + dir[i], result);
                visited[newX][newY] = false; // backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (size of matrix): ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n];
        System.out.println("Enter maze matrix (0 or 1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        List<String> result = new ArrayList<>();
        if (maze[0][0] == 1) {
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
            solveMaze(maze, n, 0, 0, visited, "", result);
        }

        if (result.isEmpty()) {
            System.out.println("No path exists.");
        } else {
            System.out.println("All possible paths: " + result);
        }
    }
}
