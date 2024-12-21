## Problem Description

Little Charlie loves candies and is participating in the International Candy Picking Contest. In this competition, there are several boxes filled with candies, placed in a grid. The grid consists of `M` rows and `N` columns. Each box contains a specific number of candies.

Charlie can select a box, and when he does, all the boxes in the same row and column are emptied. His goal is to maximize the total number of candies he can collect by selecting boxes wisely.

The challenge is to determine the maximum number of candies Charlie can collect under these conditions. 

## Input

The input contains multiple test cases.

For each test case:
1. The first line contains two integers `M` and `N` (1 ≤ M, N ≤ 1000), representing the number of rows and columns in the grid.
2. The next `M` lines each contain `N` integers, where each integer represents the number of candies in the corresponding box. Each box will contain at least 1 and at most 1000 candies.

The input ends with a line containing two zeros separated by a space, indicating the end of input.

## Output

For each test case, output a single integer, the maximum number of candies Charlie can collect.

## Solution

To solve this problem, we use **Dynamic Programming (DP)**. Here's the approach in detail:

1. **Horizontal DP**:
   For each row, we calculate the maximum candies that can be collected by selecting boxes while respecting the horizontal constraints. This step ensures that we choose boxes that maximize the candy collection in each row, while not exceeding the constraints of picking boxes from adjacent columns.

2. **Vertical DP**:
   After processing each row independently, we process the grid considering vertical constraints. This step ensures that if Charlie picks a box, all boxes in the same column and row are emptied, which is a crucial part of the problem.

3. **Transition between states**:
   When processing the grid:
   - For each row, if Charlie picks a box, the adjacent boxes in the same row and column are emptied.
   - We calculate the maximum candies he can collect by either picking the current box or not picking it, depending on the candy count in the adjacent rows and columns.

### Dynamic Programming Transition Formula:

- **Row-wise DP**: For each row, compute the maximum candies collected considering boxes up to the current box.
- **Column-wise DP**: For each column, compute the maximum candies by considering previous selections and taking into account the constraints on the rows.

## Time Complexity

- **Time Complexity**: The solution iterates over each test case, processing every box in the grid. Hence, the time complexity per test case is \( O(M \times N) \), where \( M \) is the number of rows and \( N \) is the number of columns.
  
- **Space Complexity**: The solution uses additional space for storing DP tables, which requires \( O(M \times N) \) space.