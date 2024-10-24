# Problem Description

Tarzan needs to maintain order in the forest, and to do so, he travels between trees using vines. After a storm, only 
𝑁 trees remain, and he wants to know if he can travel between all of them using the vines. He can only travel between two trees if the distance between them is less than or equal to the vine's range 
𝐷.

The objective is to check if Tarzan can reach all the trees from any starting tree, possibly passing through other trees along the way.

## Input:

- **N**: Number of remaining trees (2 ≤ N ≤ 1000).
- **D**: Vine's range in meters (1 ≤ D ≤ 5000).
- **(X<sub>i</sub>, Y<sub>i</sub>)**: Coordinates of each tree on the plane (0 ≤ X<sub>i</sub>, Y<sub>i</sub> ≤ 5000).

## Output:

- "S": Tarzan can travel between all trees.
- "N": Tarzan cannot travel between all trees.

# Solution

## 1. Modeling the Problem as a Graph

- Each tree is a node (vertex) in a graph.
- There is an edge between two nodes (trees) i and j if the distance between them is less than or equal to D.
- The Euclidean distance between two trees with coordinates (X<sub>i</sub>, Y<sub>i</sub>) and (X<sub>j</sub>, Y<sub>j</sub>):
    - d(i,j) = √((X<sub>i</sub> - X<sub>j</sub>)² + (Y<sub>i</sub> - Y<sub>j</sub>)²)
- Instead of calculating the square root, we compare the squares of the distances:
    - d(i,j)² ≤ D²

## 2. Objective

- Check if the graph is connected, meaning it is possible to reach all trees starting from any tree.
- To do this, we use Depth-First Search (DFS) to explore the graph.

# Implementation

## 1. Input Data

- Read the number of trees N and the vine's range D.
- Read the coordinates (X<sub>i</sub>, Y<sub>i</sub>) of each tree.

## 2. Graph Construction

- Create an adjacency list connecting trees with a distance ≤ D.
- For each pair of trees i and j, calculate the distance and add an edge between them if the distance is valid.

## 3. Depth-First Search (DFS)

- Use DFS to check if all trees can be visited starting from one initial tree.
- Mark the visited trees in a boolean array `visited[]`.

## 4. Check Connectivity

- After the DFS, check if all trees have been visited.
- If all were visited, the graph is connected and the answer is "S". Otherwise, the answer is "N".