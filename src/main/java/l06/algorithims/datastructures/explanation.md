# Algorithm Patterns and Exercises

This guide explains the 15 core algorithm patterns in this course and presents every exercise in a professional problem-statement style.

For each pattern:
- understand the core idea,
- identify when to apply it,
- then solve the exercises in the given order.

---

## 1) Two Pointers

**Pattern Explanation**  
Two pointers move through data (usually from opposite ends or at different speeds) to reduce brute-force complexity. This pattern is common in sorted arrays, partitioning tasks, and pair/triplet optimization problems.

**When to Use**  
Use Two Pointers when you need efficient pair/triplet decisions, in-place rearrangement, or window boundary movement based on value comparisons.

### 1. Container With Most Water
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an array `heights` where each value is the height of a vertical wall, choose two walls that form a container. Return the maximum area of water the container can hold. The area is `width * min(leftHeight, rightHeight)`.

### 2. Two Sum (Sorted Array)
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a sorted integer array and a target value, find two numbers whose sum equals the target. Return their indices (or positions) according to the platform requirement.

### 3. 3-Sum
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an integer array, return all unique triplets `[a, b, c]` such that `a + b + c = 0`. The output must not contain duplicate triplets.

### 4. Triangle Numbers
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an integer array, count how many index triplets can form a valid triangle. A triplet is valid if the sum of two sides is greater than the third side.

### 5. Move Zeroes
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Given an array, move all zero values to the end while preserving the relative order of non-zero elements. Perform this in place.

### 6. Sort Colors
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an array containing only `0`, `1`, and `2`, sort it in place so values of the same type are adjacent and in the order `0`, `1`, `2`.

### 7. Trapping Rain Water
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Given an elevation map represented by bar heights, compute how much water is trapped after raining.

---

## 2) Sliding Window

**Pattern Explanation**  
Sliding Window maintains a contiguous range and updates it incrementally as boundaries move. It is efficient for subarray/substring optimization tasks.

**When to Use**  
Use this pattern for "longest", "shortest", "maximum", "minimum", or "count" questions over contiguous segments.

### 1. Maximum Sum of Subarrays of Size K
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Given an array and an integer `k`, find the maximum sum among all contiguous subarrays of size `k`.

### 2. Max Points You Can Obtain From Cards
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** You can pick exactly `k` cards from either end of the array. Return the maximum score obtainable.

### 3. Max Sum of Distinct Subarrays Length k
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an array and `k`, find the maximum sum of any contiguous subarray of length `k` that contains only distinct elements.

### 4. Longest Substring Without Repeating Characters
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a string, return the length of the longest substring with no repeated characters.

### 5. Longest Repeating Character Replacement
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an uppercase string and integer `k`, return the length of the longest substring that can be made of one repeated letter after at most `k` character replacements.

---

## 3) Intervals

**Pattern Explanation**  
Interval problems focus on overlap, ordering, and merging of ranges. Sorting by start or end point is typically the first step.

**When to Use**  
Use Intervals when input represents time ranges, numeric segments, or schedules with conflict/merge decisions.

### 1. Can Attend Meetings
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Given meeting intervals, determine whether a person can attend all meetings without overlap.

### 2. Insert Interval
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given non-overlapping intervals sorted by start time, insert a new interval and merge where necessary.

### 3. Non-Overlapping Intervals
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given intervals, return the minimum number of intervals to remove so the rest are non-overlapping.

### 4. Merge Intervals
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a collection of intervals, merge all overlapping intervals and return the resulting non-overlapping set.

### 5. Employee Free Time
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Given schedules for multiple employees, return finite time intervals when all employees are free.

---

## 4) Stack

**Pattern Explanation**  
Stack (LIFO) is used for nested structure validation, monotonic processing, and nearest-greater/nearest-smaller logic.

**When to Use**  
Use Stack in bracket matching, expression decoding, histogram boundaries, and next-element problems.

### 1. Valid Parentheses
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Given a string containing bracket characters, determine whether it is valid based on proper opening/closing order and pairing.

### 2. Decode String
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Decode an encoded string where patterns such as `k[encoded_string]` represent repeated substrings, including nested patterns.

### 3. Longest Valid Parentheses
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Given a string of parentheses, return the length of the longest valid (well-formed) parentheses substring.

### 4. Daily Temperatures
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** For each day, return how many days must pass until a warmer temperature occurs. If none, return `0` for that day.

### 5. Largest Rectangle in Histogram
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Given bar heights of a histogram, return the area of the largest rectangle that can be formed.

---

## 5) Linked List

**Pattern Explanation**  
Linked List problems rely on pointer manipulation rather than index access. Common techniques include slow/fast pointers, reversal, and controlled relinking.

**When to Use**  
Use this pattern when node order must be modified in place or when cycle/middle/partition logic is required.

### 1. Linked List Cycle
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Determine whether a linked list contains a cycle.

### 2. Palindrome Linked List
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Given a singly linked list, check whether its node values read the same forward and backward.

### 3. Remove Nth Node From End of List
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Remove the `n`th node from the end of a linked list and return the updated head.

### 4. Reorder List
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Reorder a linked list from `L0 -> L1 -> ... -> Ln` into `L0 -> Ln -> L1 -> Ln-1 -> ...` in place.

### 5. Swap Nodes in Pairs
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Swap every two adjacent nodes in a linked list and return the new head.

---

## 6) Binary Search

**Pattern Explanation**  
Binary Search halves the search space each step. It applies not only to sorted arrays, but also to monotonic answer spaces.

**When to Use**  
Use when the problem has ordered structure or a yes/no feasibility condition that changes monotonically.

### 1. Apple Harvest (Koko Eating Bananas)
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given banana piles and `h` hours, find the minimum integer eating speed `k` so all bananas are eaten within `h` hours.

### 2. Search in Rotated Sorted Array
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a rotated sorted array and a target, return the target index if found; otherwise return `-1`.

### 3. Split Array Largest Sum
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Split an array into `m` non-empty contiguous subarrays such that the largest subarray sum is minimized. Return that minimized value.

### 4. Kth Smallest Element in a Sorted Matrix
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** In a matrix where rows and columns are sorted ascending, return the `k`th smallest element.

### 5. Minimum Shipping Capacity
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given package weights and a deadline in days, return the minimum ship capacity needed to deliver all packages in order.

---

## 7) Heap

**Pattern Explanation**  
A heap (priority queue) allows efficient retrieval of the smallest or largest element while processing dynamic data.

**When to Use**  
Use for top-`k`, merging sorted streams, running medians, and repeated best-candidate extraction.

### 1. Kth Largest Element in an Array
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an unsorted array and integer `k`, return the `k`th largest element.

### 2. K Closest Points to Origin
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given points on a 2D plane, return the `k` points closest to the origin by Euclidean distance.

### 3. Find K Closest Elements
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a sorted array, an integer `k`, and target `x`, return the `k` closest elements to `x` in sorted order.

### 4. Merge K Sorted Lists
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Merge `k` sorted linked lists into one sorted linked list.

### 5. Find Median from Data Stream
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Design a structure that supports inserting numbers from a stream and returning the median at any time.

---

## 8) Depth-First Search (DFS)

**Pattern Explanation**  
DFS explores one path deeply before backtracking. It is commonly used for tree traversal, component discovery, and recursive state exploration.

**When to Use**  
Use DFS for path validation, structural checks, exhaustive branch search, and flood/region traversal.

### 1. Maximum Depth of Binary Tree
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Return the maximum depth of a binary tree.

### 2. Path Sum
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Determine whether a binary tree has a root-to-leaf path whose values sum to a target.

### 3. Validate Binary Search Tree
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a binary tree, determine whether it satisfies BST ordering constraints for every node.

### 4. Calculate Tilt
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Compute the total tilt of a binary tree, where each node tilt is the absolute difference between left and right subtree sums.

### 5. Diameter of a Binary Tree
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Return the length of the longest path between any two nodes in a binary tree.

### 6. Path Sum II
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Return all root-to-leaf paths in a binary tree where the sum of node values equals a target.

### 7. Longest Univalue Path
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Find the length of the longest path where all nodes have the same value.

### 8. Copy Graph
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Given a reference to a node in a connected graph, return a deep copy of the entire graph.

### 9. Graph Valid Tree
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given `n` nodes and undirected edges, determine whether the graph forms exactly one valid tree.

### 10. Flood Fill
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Recolor a connected region in a 2D image starting from a given cell and original color.

### 11. Number of Islands
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a 2D grid of land and water, count the number of connected islands.

### 12. Surrounded Regions
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Capture all regions of `O` that are fully surrounded by `X` in a 2D board.

### 13. Pacific Atlantic Water Flow
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given cell heights, return coordinates where water can flow to both the Pacific and Atlantic oceans.

---

## 9) Breadth-First Search (BFS)

**Pattern Explanation**  
BFS explores by layers using a queue. It is ideal for minimum-step traversal in unweighted graphs and level-based tree processing.

**When to Use**  
Use BFS for shortest path in unweighted settings, level-order operations, and multi-source spread simulations.

### 1. Level Order Sum
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Traverse a binary tree level by level and compute the sum for each level according to the problem requirement.

### 2. Rightmost Node
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Return the rightmost visible node at each level of a binary tree.

### 3. Zigzag Level Order
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Perform binary-tree level-order traversal where direction alternates between levels.

### 4. Maximum Width of Binary Tree
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Return the maximum width among all levels of a binary tree, including null gaps between end nodes.

### 5. Minimum Knight Moves
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** On an infinite chessboard, return the minimum number of knight moves required to reach a target coordinate.

### 6. Rotting Oranges
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a grid with empty cells, fresh oranges, and rotten oranges, return minutes needed for all fresh oranges to rot, or `-1` if impossible.

### 7. 01-Matrix
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a binary matrix, return a matrix where each cell stores distance to the nearest zero.

### 8. Bus Routes
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Given bus routes, source stop, and target stop, return the minimum number of buses needed to travel from source to target.

---

## 10) Backtracking

**Pattern Explanation**  
Backtracking incrementally builds candidates, recursively explores choices, and undoes decisions when constraints fail.

**When to Use**  
Use for combinational generation, constrained search, partitioning, and puzzle-like placement problems.

### 1. Word Search
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a character grid and a word, determine whether the word exists by moving horizontally or vertically to adjacent cells without reusing a cell.

### 2. Subsets
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an array of unique integers, return all possible subsets (the power set).

### 3. Generate Parentheses
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given `n` pairs of parentheses, generate all valid combinations.

### 4. Combination Sum
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given distinct candidate numbers and a target, return all unique combinations where numbers can be reused and sum to target.

### 5. Palindrome Partitioning
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a string, partition it into substrings so every substring is a palindrome. Return all possible partitions.

### 6. N-Queens
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Place `n` queens on an `n x n` board so no two queens attack each other. Return all valid board configurations.

---

## 11) Graphs

**Pattern Explanation**  
Graph problems model entities as nodes and relationships as edges. Solutions often combine traversal, topological ordering, or shortest-path algorithms.

**When to Use**  
Use when solving prerequisites, routing, connectivity, weighted path optimization, or network reachability.

### 1. Course Schedule
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given course prerequisites, determine whether all courses can be completed.

### 2. Course Schedule II
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given course prerequisites, return one valid order in which all courses can be completed.

### 3. Network Delay Time
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given directed weighted edges and a source node, return the time required for the signal to reach all nodes, or `-1` if impossible.

### 4. Cheapest Flights Within K Stops
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given flight edges with costs, find the cheapest price from source to destination with at most `k` stops.

### 5. Path With Minimum Effort
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a grid of heights, find a path from top-left to bottom-right that minimizes the maximum absolute difference between adjacent cells.

### 6. Find City with Fewest Reachable
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given weighted city connections and a distance threshold, return the city that can reach the fewest other cities within that threshold.

---

## 12) Dynamic Programming

**Pattern Explanation**  
Dynamic Programming solves problems with overlapping subproblems and optimal substructure by storing intermediate results.

**When to Use**  
Use when brute force revisits the same states and the final answer can be built from smaller subproblems.

### 1. Counting Bits
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** For every integer from `0` to `n`, return the number of `1` bits in its binary representation.

### 2. Decode Ways
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a string of digits, return how many ways it can be decoded using `1 -> A` through `26 -> Z`.

### 3. Maximal Square
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a binary matrix, return the area of the largest square containing only `1`s.

### 4. Unique Paths
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given grid dimensions `m` and `n`, return the number of unique paths from top-left to bottom-right moving only right or down.

### 5. Longest Increasing Subsequence
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an array of integers, return the length of the longest strictly increasing subsequence.

### 6. Word Break
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a string and a dictionary, determine whether the string can be segmented into one or more dictionary words.

### 7. Maximum Profit in Job Scheduling
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given job start times, end times, and profits, choose non-overlapping jobs to maximize total profit.

### 8. Paint House
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given painting costs for each house and color, return the minimum total cost such that adjacent houses have different colors.

### 9. Paint House II
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Generalize Paint House to `k` colors and compute the minimum cost while keeping adjacent houses different.

### 10. Minimum Window Subsequence
**Difficulty:** Hard  
**DESCRIPTION (inspired by LeetCode.com):** Given strings `s1` and `s2`, return the minimum window in `s1` where `s2` appears as a subsequence.

---

## 13) Greedy Algorithms

**Pattern Explanation**  
Greedy methods choose the best local action at each step and rely on a proof that local optimality leads to global optimality.

**When to Use**  
Use when a valid exchange argument or monotonic progress property exists.

### 1. Best Time to Buy and Sell Stock
**Difficulty:** Easy  
**DESCRIPTION (inspired by LeetCode.com):** Given daily stock prices, return the maximum profit from one buy and one sell transaction.

### 2. Gas Station
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given gas available and travel cost between stations on a circular route, return a starting index that allows completing the circuit, or `-1`.

### 3. Jump Game
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given max jump lengths at each index, determine whether you can reach the last index.

### 4. Jump Game II
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given max jump lengths at each index, return the minimum number of jumps needed to reach the last index.

### 5. Partition Labels
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Partition a string into as many parts as possible so each letter appears in at most one part. Return partition sizes.

---

## 14) Trie

**Pattern Explanation**  
A Trie stores strings by shared prefixes, enabling fast prefix queries and dictionary operations.

**When to Use**  
Use for autocomplete, prefix existence checks, and high-volume string lookup by prefix.

### 1. Implement Trie Methods
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Design and implement Trie operations such as `insert`, `search`, and `startsWith`.

### 2. Prefix Matching
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a dictionary and query prefixes, return matches or counts according to prefix constraints.

---

## 15) Prefix Sum

**Pattern Explanation**  
Prefix sums precompute cumulative totals so range-sum queries become constant time.

**When to Use**  
Use for repeated subarray/subsequence sum queries and counting tasks based on cumulative differences.

### 1. Count Vowels in Substrings
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given a string and substring queries, return the number of vowels in each queried range efficiently.

### 2. Subarray Sum Equals K
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an integer array and target `k`, return the number of contiguous subarrays whose sum equals `k`.

---

## Supplementary: Matrix Techniques

These exercises are reinforcement problems for 2D traversal and in-place matrix transformation.

### 1. Spiral Matrix
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Given an `m x n` matrix, return all elements in spiral order.

### 2. Rotate Image
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** Rotate an `n x n` matrix by 90 degrees clockwise in place.

### 3. Set Matrix Zeroes
**Difficulty:** Medium  
**DESCRIPTION (inspired by LeetCode.com):** If any matrix cell is zero, set its entire row and column to zero in place.

---

## Recommended Learning Sequence

1. Two Pointers -> Sliding Window -> Intervals  
2. Stack -> Linked List -> Binary Search -> Heap  
3. DFS -> BFS -> Graphs -> Backtracking  
4. Dynamic Programming -> Greedy -> Trie -> Prefix Sum  
5. Matrix Techniques for reinforcement

## Student Practice Checklist

For every solved problem, write:
- the chosen pattern,
- time complexity,
- space complexity,
- one alternative approach.
