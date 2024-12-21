import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String[] line = br.readLine().trim().split(" ");
            int M = Integer.parseInt(line[0]);
            int N = Integer.parseInt(line[1]);
            
            if (M == 0 && N == 0) break;
            
            int[][] grid = new int[M][N];
            for (int i = 0; i < M; i++) {
                line = br.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(line[j]);
                }
            }
            
            System.out.println(solve(grid, M, N));
        }
    }
    
    static int solve(int[][] grid, int M, int N) {
        int[][] dp = new int[M][N];
        
        // First process each row independently to find maximum possible
        // candies when considering horizontal constraints
        for (int i = 0; i < M; i++) {
            dp[i] = processRow(grid[i], N);
        }
        
        // Process the grid considering vertical constraints
        int[][] finalDp = new int[M][N];
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                if (i == 0) {
                    finalDp[i][j] = dp[i][j];
                } else {
                    // If we pick current cell, we can't pick from adjacent rows
                    int withCurrent = dp[i][j];
                    if (i >= 2) {
                        withCurrent += finalDp[i-2][j];
                    }
                    
                    // If we don't pick current cell
                    int withoutCurrent = finalDp[i-1][j];
                    
                    finalDp[i][j] = Math.max(withCurrent, withoutCurrent);
                }
            }
        }
        
        return finalDp[M-1][N-1];
    }
    
    static int[] processRow(int[] row, int N) {
        int[] dp = new int[N];
        
        // Base cases
        if (N >= 1) dp[0] = row[0];
        if (N >= 2) dp[1] = Math.max(row[0], row[1]);
        
        // Fill dp array
        for (int i = 2; i < N; i++) {
            // Either pick current candy (and skip adjacent)
            // or take the best solution up to previous position
            dp[i] = Math.max(dp[i-2] + row[i], dp[i-1]);
        }
        
        return dp;
    }
}