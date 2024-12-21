# Problem Description

Dentists are extremely meticulous in their work, requiring precision in all activities. Pedro, like all dentists, is no exception. Unfortunately, his secretary is not very organized and, in an effort to accommodate patients, schedules appointments without considering existing appointments, leading to overlapping schedules. For example, if an appointment starts at 9:00 and lasts 2 hours, no other appointment should be scheduled to start at 10:00.

Noticing conflicts in his schedule, Pedro asked for your help to determine the maximum number of appointments that can be attended without overlapping.

# Input

The input consists of:

- The first line contains an integer **N** (1 ≤ N ≤ 10,000) representing the number of appointments scheduled by the secretary.
- The next **N** lines each contain two integers **X** and **Y** (0 ≤ X < Y ≤ 1,000,000), separated by a space, which represent the start time (**X**) and end time (**Y**) of an appointment.
  - Appointments are provided in chronological order of their start times.
  - Multiple appointments may start at the same time.

# Output

The program must print a single integer representing the maximum number of appointments that can be attended without overlapping.

# Solution

## Problem

- To maximize the number of appointments attended, prioritize:
  1. Selecting appointments that finish earliest.
  2. Ensuring that subsequent appointments start only after the previous one ends.

## Approach

1. Parse the input to retrieve the list of appointments.
2. Sort the appointments by their end times (ascending order).
3. Use a greedy algorithm:
   - Track the end time of the last attended appointment.
   - If the next appointment starts after or at the end time of the last attended appointment, attend it and update the last attended end time.
4. Count and output the maximum number of appointments attended.

## Complexity

- **Time Complexity**: O(N log N) due to sorting the appointments.
- **Space Complexity**: O(N) to store the appointments.