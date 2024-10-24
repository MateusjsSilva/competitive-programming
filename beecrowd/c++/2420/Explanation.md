# Territory Division Problem

After a 50-year war, the countries Tombólia do Oeste and Tombólia do Leste have decided to sign a peace treaty. To end the conflict, they need to fairly divide their territory. The territory is made up of several sections of different sizes, arranged sequentially, and they want to find a division point that satisfies the following condition:

The sum of the sections from the left up to section `k` must be equal to the sum of the sections from `k+1` onward on the right.
The task is to determine the section `k` that divides the territory according to this condition.

### Example:

Given a set of N territory sections, represented by integers:

- Section 1: `a1`
- Section 2: `a2`
- ...
- Section N: `aN`

Find the division point `k` such that:
```
a1 + a2 + ... + ak = ak+1 + ak+2 + ... + aN
```

### Input

The first line of input contains an integer `N` (1 ≤ N ≤ 10⁵), indicating the number of territory sections.
The second line contains `N` integers `a1, a2, ..., aN` (1 ≤ ai ≤ 100), separated by spaces, representing the length of each section.

### Output
The program should print a single line containing the index of the section `k` where the division should occur (based on 1-based indexing).

**Note:** The problem guarantees that there is always a division point that satisfies the required condition.

## Approach to the Solution

#### Steps to Solve the Problem:

1. **Sum All Sections:** First, we need to calculate the total sum of all sections.
2. **Progressive Calculation:** As we iterate through the array of sections, we accumulate the sum of the sections on the left (initially 0). For each position `k`, the sum of the right sections can be obtained by subtracting the left sum from the total sum.
3. **Check the Division Point:** When the accumulated sum of the left sections equals the sum of the right sections, we have found the point `k` where the division should occur.

## Code:

1. **Input:** We read the number of sections and the size of each section.
2. **Total Sum Calculation:** Initially, we sum all the sections.
3. **Iteration to Find the Division Point:**
    - For each section, we subtract its value from the total sum (to get the right sum).
    - We check if the left sum equals the right sum. If so, we print the index of section `k`.

**Optimization:** The code iterates through the array once, resulting in a linear time complexity of O(N).