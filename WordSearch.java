import java.util.*;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (visited[i][j] || board[i][j] != word.charAt(idx)) return false;

        visited[i][j] = true;
        boolean res = dfs(board, word, idx + 1, i + 1, j, visited) ||
                      dfs(board, word, idx + 1, i - 1, j, visited) ||
                      dfs(board, word, idx + 1, i, j + 1, visited) ||
                      dfs(board, word, idx + 1, i, j - 1, visited);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and cols: ");
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[m][n];
        System.out.println("Enter grid row by row:");
        for (int i = 0; i < m; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        System.out.print("Enter word: ");
        String word = sc.nextLine();

        System.out.println("Word exists? " + exist(board, word));
    }
}
