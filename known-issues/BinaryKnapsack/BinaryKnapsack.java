import java.util.Scanner;

public class BinaryKnapsack {

    // Function to solve the 0/1 knapsack problem using dynamic programming
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;

        // Create a 2D array to store the maximum values at each capacity and item
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill the dp array using dynamic programming approach
        for (int i = 1; i <= n; i++) {
            for (int c = 0; c <= capacity; c++) {
                if (weights[i - 1] <= c) {
                    // Either take the item or leave it
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - weights[i - 1]] + values[i - 1]);
                } else {
                    // If the item can't be taken, carry forward the previous value
                    dp[i][c] = dp[i - 1][c];
                }
            }
        }

        // Return the maximum value that can be achieved with the given capacity
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTRADA:");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int capacity = scanner.nextInt();

            int[] weights = new int[n];
            int[] values = new int[n];
            for (int j = 0; j < n; j++) {
                weights[j] = scanner.nextInt();
                values[j] = scanner.nextInt();
            }

            // Calculate and print the maximum value that can be carried in the knapsack
            int result = knapsack(weights, values, capacity);
            System.out.println("SAIDA:\n" + result);
        }

        scanner.close();
    }
}