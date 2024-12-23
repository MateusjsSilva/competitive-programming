import java.util.Scanner;

public class IterativePathSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTRADA:");
        int n = scanner.nextInt();

        // Initialize the grid and sum matrices with 0 values
        int[][] grid = new int[n][n];
        int[][] sum = new int[n + 1][n + 1];

        // Read the values into the grid matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // Fill the sum matrix using dynamic programming
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                sum[row][col] = Math.max(sum[row - 1][col], sum[row][col - 1]) + grid[row - 1][col - 1];
            }
        }

        // Print the result
        System.out.println("SAIDA:\n" + sum[n][n]);

        scanner.close();
    }
}