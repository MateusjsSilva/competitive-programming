import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = 1;

        while (true) {
            int N = scanner.nextInt(); // Number of books
            int C = scanner.nextInt(); // Capacity of the bag

            if (N == 0 && C == 0) {
                break;
            }

            int[] weights = new int[N];
            int[] values = new int[N];

            for (int i = 0; i < N; i++) {
                weights[i] = scanner.nextInt();
                values[i] = scanner.nextInt();
            }

            int[][] dp = new int[N + 1][C + 1];

            for (int i = 1; i <= N; i++) {
                for (int w = 0; w <= C; w++) {
                    if (weights[i - 1] <= w) {
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }

            System.out.printf("Caso %d: %d\n", testCase, dp[N][C]);
            testCase++;
        }

        scanner.close();
    }
}