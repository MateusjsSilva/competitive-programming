# Problem Description

Your favorite soccer team is playing in a charity championship, part of a global effort to raise funds for children in need. As in a regular championship:

- Three points are awarded to the team that wins a match.
- Zero points are given to the losing team.
- If the match ends in a draw, each team receives one point.

Your team has played **N** matches during the first phase of the championship, which has already concluded. Only teams with the most accumulated points will advance to the second phase. However, as the main objective of the championship is fundraising, before determining which teams move forward, each team can buy additional goals. These purchased goals count as goals scored and can be used to alter the result of any match your team played.

Your team has a budget to buy up to **G** goals. Can you determine the maximum number of points your team can obtain after purchasing the goals, assuming other teams do not buy any goals?

# Input

The input contains multiple test cases and ends with EOF. Each test case consists of:

- A line with two integers **N** (1 ≤ N ≤ 10⁵) and **G** (0 ≤ G ≤ 10⁶):
  - **N**: Number of matches your team played.
  - **G**: Number of goals your team can buy.
- **N** subsequent lines, each containing two integers **S** and **R** (0 ≤ S, R ≤ 100):
  - **S**: Goals scored by your team before purchasing goals.
  - **R**: Goals conceded by your team before purchasing goals.

# Output

For each test case, print a single line with an integer representing the maximum total points your team can achieve after buying the goals.

# Solution

## Problem Analysis

- A win gives 3 points, a draw gives 1 point, and a loss gives 0 points.
- Goals can be used to:
  - Turn a loss into a draw (requires `R - S` goals).
  - Turn a draw into a win (requires `R - S + 1` goals).
- To maximize points, prioritize:
  1. Converting losses into wins.
  2. Converting draws into wins.

## Steps to Solve

1. Parse the input to get the number of matches (**N**) and available goals (**G**).
2. Separate matches into:
   - Wins (already worth 3 points).
   - Draws (can be converted into wins).
   - Losses (can be converted into draws or wins).
3. Sort losses by the number of goals needed to convert them into draws (ascending).
4. Use the available goals:
   - First, turn losses into draws, then into wins.
   - Next, turn draws into wins.
5. Calculate and print the total points.

## Complexity

- **Time Complexity**: O(N log N) due to sorting the matches by goals required.
- **Space Complexity**: O(N) to store the differences.