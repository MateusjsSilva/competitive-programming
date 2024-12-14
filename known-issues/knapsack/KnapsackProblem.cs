using System;

public class KnapsackProblem
{
    /// <summary>
    /// Solves the 0/1 knapsack problem using dynamic programming.
    /// Given a set of items with values and weights, determines the maximum value
    /// that can be placed in a knapsack with a limited capacity.
    ///
    /// <param name="capacity">Maximum capacity of the knapsack.</param>
    /// <param name="weights">Array containing the weights of the items.</param>
    /// <param name="values">Array containing the values of the items.</param>
    /// <param name="n">Total number of available items.</param>
    /// <returns>The maximum value that can be placed in the knapsack.</returns>
    /// 
    /// The function logic is based on a dynamic programming approach:
    /// - A two-dimensional array `dp` is created where `dp[i, w]` represents the
    ///   maximum value that can be obtained using the first `i` items and with
    ///   maximum capacity `w`.
    /// - For each item `i` and capacity `w`:
    ///     - If the weight of the current item (`weights[i - 1]`) is less than or equal to capacity `w`,
    ///       we decide whether to include or exclude the item.
    ///       The formula used is:
    ///       dp[i, w] = Max(dp[i - 1, w], values[i - 1] + dp[i - 1, w - weights[i - 1]]).
    ///     - Otherwise, the item cannot be included:
    ///       dp[i, w] = dp[i - 1, w].
    /// - After processing all items and capacities, the maximum value will be
    ///   in `dp[n, capacity]`.
    ///
    /// Complexity:
    /// - Time: O(n × capacity), where `n` is the number of items and `capacity` is the knapsack capacity.
    /// - Space: O(n × capacity) to store the `dp` array.
    /// </summary>
    public static int SolveKnapsack(int capacity, int[] weights, int[] values, int n)
    {
        int[,] dp = new int[n + 1, capacity + 1];

        for (int i = 1; i <= n; i++)
        {
            for (int w = 1; w <= capacity; w++)
            {
                if (weights[i - 1] <= w)
                {
                    dp[i, w] = Math.Max(dp[i - 1, w], values[i - 1] + dp[i - 1, w - weights[i - 1]]);
                }
                else
                {
                    dp[i, w] = dp[i - 1, w];
                }
            }
        }

        return dp[n, capacity];
    }

    public static void Main(string[] args)
    {
        Console.Write("Digite o número de itens: ");
        int n = int.Parse(Console.ReadLine());

        int[] weights = new int[n];
        int[] values = new int[n];

        Console.WriteLine("Digite os pesos dos itens:");
        for (int i = 0; i < n; i++)
        {
            weights[i] = int.Parse(Console.ReadLine());
        }

        Console.WriteLine("Digite os valores dos itens:");
        for (int i = 0; i < n; i++)
        {
            values[i] = int.Parse(Console.ReadLine());
        }

        Console.Write("Digite a capacidade da mochila: ");
        int capacity = int.Parse(Console.ReadLine());

        int maxValue = SolveKnapsack(capacity, weights, values, n);

        Console.WriteLine($"O valor máximo que pode ser colocado na mochila é: {maxValue}");

        /*
         Caso teste:
            Digite o número de itens: 3
            Digite os pesos dos itens:
            10
            6
            6
            Digite os valores dos itens:
            100
            55
            50
            Digite a capacidade da mochila: 12
            O valor máximo que pode ser colocado na mochila é: 105
         */
    }
}