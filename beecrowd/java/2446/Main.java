import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int M = sc.nextInt();
        int[] coins = new int[M];

        for (int i = 0; i < M; i++) {
            coins[i] = sc.nextInt();
        }

        // Boolean array to track which sums are possible
        boolean[] dp = new boolean[V + 1];
        dp[0] = true; // It's always possible to make the sum 0 (using no coins)

        // Iterate through each coin and update the dp array
        for (int coin : coins) {
            for (int j = V; j >= coin; j--) {
                if (dp[j - coin]) {
                    dp[j] = true;
                }
            }
        }

        if (dp[V]) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }

        sc.close();
    }
}