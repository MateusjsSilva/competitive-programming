# Problem Description

Machado is an enthusiastic writer who has penned numerous short stories, travelogues, and even a small novel. Now, he wants to participate in a short story competition with strict formatting rules. The competition specifies:

- The maximum number of characters per line.
- The maximum number of lines per page.
- The maximum total number of pages.

Additionally, each word must fit entirely within a line; words cannot be split across two lines. Machado aims to include as many words as possible in his story while adhering to the competition's rules. Given the constraints and the list of words in Machado's story, determine the minimum number of pages required to format the story according to the rules.

## Input

- The first line of each test case contains three integers:
  - **N**: Number of words in Machado's story (2 ≤ N ≤ 1000).
  - **L**: Maximum number of lines per page (1 ≤ L ≤ 30).
  - **C**: Maximum number of characters per line (1 ≤ C ≤ 70).
- The second line contains **N** words separated by single spaces. Each word:
  - Consists of uppercase or lowercase English letters.
  - Has a length of at least 1 and at most `C`.

The input ends at EOF (End of File).

## Output

- For each test case, print a single integer indicating the minimum number of pages required to format the story according to the competition's rules.

# Solution

## 1. Problem Analysis

- Words must be arranged into lines such that:
  - The sum of word lengths in a line, including spaces between them, does not exceed `C`.
  - Words that do not fit in a line start a new line.
- Lines are grouped into pages, with each page containing at most `L` lines.
- The task is to calculate the number of pages required for the given words.

## 2. Steps to Solve

### 2.1 Input Parsing

- Read the integers `N`, `L`, and `C`.
- Read the list of words.

### 2.2 Line Formation

- Initialize counters for lines and current line length.
- Iterate over the words:
  - Check if the current word fits in the remaining space of the current line.
  - If it fits, add its length (plus a space, if applicable) to the current line.
  - Otherwise, start a new line and reset the current line length.
- After processing all words, count the last line if it is non-empty.

### 2.3 Page Calculation

- Calculate the total number of pages by dividing the number of lines by `L` and rounding up.

# Implementation

## Algorithm Overview

1. Initialize counters for lines and pages.
2. For each word in the input:
   - Check if it fits in the current line with existing words.
   - If it fits, add it to the current line.
   - If not, start a new line and increment the line counter.
3. After processing all words, calculate the number of pages by dividing the total lines by `L` and rounding up.

## Complexity

- **Time Complexity**: O(N), where N is the number of words, as each word is processed exactly once.
- **Space Complexity**: O(1), as the solution uses a fixed amount of extra memory.