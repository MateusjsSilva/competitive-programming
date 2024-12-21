# Problem Description

Vânia has a collection of books that she wants to lend to her friend Rangel during his vacation. Each book has a weight and an associated interest value. Since Rangel cannot carry all the books in his bag due to weight limitations, Vânia wants to select the books that maximize Rangel's interest while respecting the bag's weight capacity.

Your task is to write a program that helps Vânia determine the maximum interest value Rangel can carry in his bag.

## Input

The input consists of multiple test cases, each defined as follows:

1. **N** (1 ≤ N ≤ 1000) and **C** (1 ≤ C ≤ 100):
   - **N**: Number of books available.
   - **C**: Maximum capacity (weight) of the bag.

2. The next **N** lines each contain two integers:
   - **W** (1 ≤ W ≤ C): The weight of the book.
   - **V** (1 ≤ V ≤ 1000): The interest value of the book.

The input ends when both **N** and **C** are zero.

---

## Output

For each test case, output a single line in the following format:

```
Caso H: M
```

Where:
- **H**: The test case number (starting from 1).
- **M**: The maximum total interest value Rangel can carry in his bag.

---

## Solution

### Problem Analysis

This is a classic **0/1 Knapsack Problem**, where:
- Each book is an item with a weight and value.
- The goal is to maximize the total value (interest) without exceeding the bag's weight capacity.

### Algorithm

The problem is solved using **Dynamic Programming (DP)**:
1. Define a DP table `dp[i][w]` where:
   - `i` represents the first `i` books considered.
   - `w` represents the current weight capacity of the bag.

2. Transition formula:
   - If the current book's weight is less than or equal to `w`, we decide whether to:
     - Exclude the book: `dp[i][w] = dp[i-1][w]`.
     - Include the book: `dp[i][w] = dp[i-1][w - weights[i-1]] + values[i-1]`.
   - Otherwise, exclude the book: `dp[i][w] = dp[i-1][w]`.

3. Initialize the table:
   - `dp[0][w] = 0` for all `w` (no books, zero value).

4. The final solution for each test case is stored in `dp[N][C]`.

### Complexity
- **Time Complexity**: O(N * C) per test case.
- **Space Complexity**: O(N * C) for the DP table.