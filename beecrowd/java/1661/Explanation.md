# Problem Description

In the city of Gergovia, each inhabitant is a wine merchant. Every day, each person decides how much wine they want to buy or sell. The total demand and supply across the city are balanced, meaning every person is able to get the amount of wine they desire.

The challenge lies in transporting the wine between neighboring houses, where transporting one bottle of wine to an adjacent house requires one unit of work. Your task is to compute the minimum total work required to satisfy all the demands.

# Input

The input consists of multiple test cases. Each test case is defined as follows:

- `n` (2 ≤ n ≤ 100,000) - the number of inhabitants in the city.
- The next line contains `n` integers:
    - If `a[i] ≥ 0`, it means that the inhabitant at house `i` wants to buy `a[i]` bottles of wine.
    - If `a[i] < 0`, it means that the inhabitant at house `i` wants to sell `-a[i]` bottles of wine.
- You can assume that the sum of all the values in the array is 0, meaning the total demand equals the total supply.
- The input ends when `n = 0`.

# Output

For each test case, output a single line with the minimum amount of work required to satisfy the wine demands. The output should be an integer.

# Solution

## Problem Analysis

The problem asks us to minimize the total work required to transport wine between houses in a straight line. Each house either wants to buy or sell a specific number of bottles. The goal is to determine how to transport wine in such a way that the total work is minimized.

## Algorithm

The key observation is that the work is minimized when we accumulate the transportation needs (balances) from left to right:

### Balance Calculation

As we traverse the array of demands and supplies, we maintain a running balance, which represents how many bottles need to be transported at each house. For each house, the absolute value of this running balance indicates the work required to transport wine to that house.

### Work Calculation

The total work is simply the sum of the absolute values of the running balances at each step.

## Steps

1. Initialize a variable `balance = 0` to track the accumulated demand or supply.
2. Traverse through the array:
     - Update `balance` by adding the current house's demand or supply.
     - Add the absolute value of `balance` to the total work since this represents the amount of wine that needs to be transported.
3. Output the total work for each test case.

## Time Complexity

- **Time Complexity:** O(n) per test case, where `n` is the number of houses. We traverse the list of demands/supplies once.
- **Space Complexity:** O(n) for storing the list of demands and supplies.