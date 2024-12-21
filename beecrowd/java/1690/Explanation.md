# Problem Description

You are given an array of positive integers, which may not be distinct.

We need to select a non-empty subset of the array, meaning some of the numbers from the array. The value of a subset is the sum of the elements in it.

The task is to find the smallest value of a subset that **cannot** be generated.

### Example

For the array `[2, 1, 5]`, the following subsets can be formed:  
- `[1]`, `[2]`, `[5]`, `[1, 2]`, `[1, 5]`, `[2, 5]`, `[1, 2, 5]`.

The corresponding sums are:
- `1`, `2`, `5`, `3`, `6`, `7`, `8`.

The smallest subset sum that cannot be generated is `4`.

---

## Input

The input consists of multiple test cases. Each test case is defined as follows:

1. **T** (1 ≤ T ≤ 1000) - the number of test cases.
2. For each test case:
   - **N** (1 ≤ N ≤ 10,000) - the number of integers in the array.
   - The next line contains **N** positive integers separated by spaces (1 ≤ ai ≤ 10^9).

The input ends when **N = 0**.

---

## Output

For each test case, output a single line containing the smallest subset sum that cannot be generated.

---

## Solution

### Problem Analysis

The problem asks to find the smallest sum that cannot be formed by any subset of the given array. We can use a **greedy approach** to efficiently compute the result.

### Algorithm

1. **Sort the array**: Sorting helps us to check if we can form a subset sum incrementally, starting from the smallest numbers.
2. **Greedy method**:
   - We initialize `smallestMissingSum` as 1, because the smallest sum that cannot be formed initially is `1`.
   - For each number in the sorted array:
     - If the number is less than or equal to `smallestMissingSum`, it means we can form all sums up to `smallestMissingSum + num - 1`, so we update `smallestMissingSum` by adding `num`.
     - If the number is greater than `smallestMissingSum`, we stop since we cannot form `smallestMissingSum`.
3. **Time complexity**:
   - Sorting takes **O(N log N)**.
   - The greedy pass takes **O(N)**.

### Time Complexity

- **Time Complexity**: O(N log N) per test case.
- **Space Complexity**: O(N) for storing the array.