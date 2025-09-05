import java.util.*;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] h = Arrays.copyOf(heights, heights.length + 1);

        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and cols: ");
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();

        char[][] matrix = new char[m][n];
        System.out.println("Enter matrix rows (0/1 only):");
        for (int i = 0; i < m; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }

        System.out.println("Maximal rectangle area: " + maximalRectangle(matrix));
    }
}
