import java.util.*;

public class Minesweeper {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();

    private int rows;
    private int cols;
    private int mines;
    private char[][] board;        // what player sees
    private boolean[][] mineBoard; // mine locations
    private boolean[][] revealed;

    public Minesweeper(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;

        board = new char[rows][cols];
        mineBoard = new boolean[rows][cols];
        revealed = new boolean[rows][cols];

        // Initialize player board with '-'
        for (int i = 0; i < rows; i++)
            Arrays.fill(board[i], '-');

        placeMines();
    }

    private void placeMines() {
        int placed = 0;
        while (placed < mines) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (!mineBoard[r][c]) {
                mineBoard[r][c] = true;
                placed++;
            }
        }
    }

    private int countAdjacentMines(int r, int c) {
        int count = 0;
        for (int i = r - 1; i <= r + 1; i++)
            for (int j = c - 1; j <= c + 1; j++)
                if (i >= 0 && i < rows && j >= 0 && j < cols && mineBoard[i][j])
                    count++;
        return count;
    }

    private void revealCell(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || revealed[r][c])
            return;

        revealed[r][c] = true;
        int count = countAdjacentMines(r, c);
        board[r][c] = count == 0 ? ' ' : (char) (count + '0');

        if (count == 0) {
            // Recursively reveal neighbors
            for (int i = r - 1; i <= r + 1; i++)
                for (int j = c - 1; j <= c + 1; j++)
                    revealCell(i, j);
        }
    }

    private boolean checkWin() {
        int revealedCount = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (revealed[i][j])
                    revealedCount++;

        return revealedCount == rows * cols - mines;
    }

    private void printBoard() {
        System.out.print("   ");
        for (int c = 0; c < cols; c++)
            System.out.print(c + " ");
        System.out.println();

        for (int r = 0; r < rows; r++) {
            System.out.print(r + "  ");
            for (int c = 0; c < cols; c++)
                System.out.print(board[r][c] + " ");
            System.out.println();
        }
    }

    public void play() {
        while (true) {
            printBoard();
            System.out.print("Enter row and column to reveal (e.g., 1 2): ");
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                System.out.println("❌ Invalid coordinates.");
                continue;
            }

            if (mineBoard[r][c]) {
                System.out.println("\n💣 Boom! You hit a mine. Game Over.");
                revealAllMines();
                printBoard();
                break;
            } else {
                revealCell(r, c);
                if (checkWin()) {
                    System.out.println("\n🎉 Congratulations! You cleared the board!");
                    printBoard();
                    break;
                }
            }
        }
    }

    private void revealAllMines() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (mineBoard[i][j])
                    board[i][j] = '*';
    }

    public static void main(String[] args) {
        System.out.println("--- Minesweeper Game ---");
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        System.out.print("Enter number of mines: ");
        int mines = sc.nextInt();

        if (mines >= rows * cols) {
            System.out.println("Too many mines! Exiting...");
            return;
        }

        Minesweeper game = new Minesweeper(rows, cols, mines);
        game.play();
    }
}
