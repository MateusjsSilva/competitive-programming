import java.util.Scanner;

public class RecursivePathSolver {

    // Recursive function to calculate the maximum sum
    public static int maximumSum(int row, int col, int[][] grid, int[][] memo) {
        // If the coordinates are out of bounds
        if (row < 0 || col < 0) {
            return 0;
        }
        
        // If the value has already been calculated, return the stored value
        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        // Recursion to calculate the value from above and from the left
        int up = maximumSum(row - 1, col, grid, memo);
        int left = maximumSum(row, col - 1, grid, memo);

        // Store the calculated value for the current cell
        memo[row][col] = Math.max(up, left) + grid[row][col];

        return memo[row][col];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTRADA:");
        int n = scanner.nextInt();

        int[][] grid = new int[n][n];
        int[][] memo = new int[n][n];

        // Initialize the memo array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;  // Initialize with -1
            }
        }

        // Read the values for the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int result = maximumSum(n - 1, n - 1, grid, memo);

        System.out.println("SAIDA:\n" + result);

        scanner.close();
    }
}