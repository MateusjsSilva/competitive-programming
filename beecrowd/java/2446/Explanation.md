# Problem Description

You are at the supermarket, and after scanning your purchases at the cashier, you realize you have several coins in your pocket, some of which are repeated. You wonder if you can use those coins to pay exactly the total amount of your bill. The task is to determine if you can pay the exact value of your purchases using only the coins you have in your pocket.

Your task is to write a program that helps determine whether it is possible to pay the exact amount using the given coins.

---

## Input

The input consists of a single test case with the following:

1. **V** and **M**:
   - **V**: The total value of the purchase (1 ≤ V ≤ 100,000).
   - **M**: The number of coins you have in your pocket (1 ≤ M ≤ 1,000).

2. The next **M** integers represent the value of each coin you have (1 ≤ Mi ≤ 100,000).

The input ends when both **V** and **M** are zero.

---

## Output

For each test case, print a single line containing:
- **S** if it is possible to pay the exact value of the purchase with the given coins.
- **N** if it is not possible.

---

## Solution

### Problem Analysis

This problem is a variant of the **Subset Sum Problem**:
- The goal is to determine if there exists a subset of the given coins whose sum is exactly equal to the total value of the purchase `V`.

### Algorithm

We will solve the problem using **Dynamic Programming (DP)**. The main idea is to use a boolean DP array where each element indicates whether a particular sum can be achieved using a subset of the available coins.

1. **Define a DP Array**:
   - Let `dp[i]` be a boolean value indicating whether it is possible to form the sum `i` using the available coins.
   - Initially, `dp[0] = true` because we can always form the sum 0 (using no coins).

2. **Update the DP Array**:
   - For each coin, we update the DP array in reverse order (from `V` down to the coin's value) to avoid reusing the same coin multiple times.

3. **Final Check**:
   - After processing all coins, if `dp[V]` is true, it means we can form the exact sum `V` using the coins. Otherwise, it's not possible.

### Time Complexity
- **Time Complexity**: O(V * M), where `V` is the total value of the purchase and `M` is the number of coins.
- **Space Complexity**: O(V), for the DP array.