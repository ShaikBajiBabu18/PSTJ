# UNIT II – Algorithmic Thinking & Competitive Problem Patterns

## Course Outcome
Apply algorithmic patterns to develop optimized solutions.

This repository contains Java solutions for the 10 hands-on problems listed in Unit II, Week 6.

| # | Problem | Platform | Main Pattern |
|---|---|---|---|
| 1 | String Similarity | HackerRank | Z Algorithm / Prefix Matching |
| 2 | Repeated Substring Pattern | LeetCode | KMP / LPS |
| 3 | Two Strings | HackerRank | Character Presence |
| 4 | Rotate String | LeetCode | String Rotation |
| 5 | Mars Exploration | HackerRank | Pattern Comparison |
| 6 | Find All Anagrams in a String | LeetCode | Sliding Window |
| 7 | Palindrome Index | HackerRank | Two Pointers |
| 8 | Find the Index of the First Occurrence in a String | LeetCode | KMP |
| 9 | Longest Palindromic Substring | LeetCode | Manacher Algorithm |
| 10 | Circular Palindromes | HackerRank | Manacher + RMQ + Binary Search |

## Folder Structure

Each problem has its own folder:

```text
01_String_Similarity/
    Solution.java
    README.md
...
10_Circular_Palindromes/
    Solution.java
    README.md
```

## Important
- HackerRank solutions include `main()` and can be submitted as `Solution.java`.
- LeetCode solutions contain the `Solution` class and required method; paste the class into the LeetCode editor.
- Problem 1 is implemented with the Z algorithm because String Similarity asks for the prefix-match length against every suffix. This is the natural linear-time solution for that task.
- Problem 9 uses Manacher's algorithm.
- Problem 10 uses Manacher's algorithm on the doubled string, a sparse-table RMQ, and binary search to handle all rotations efficiently.

## Practice Links

1. https://www.hackerrank.com/challenges/string-similarity/problem
2. https://leetcode.com/problems/repeated-substring-pattern/
3. https://www.hackerrank.com/challenges/two-strings/problem
4. https://leetcode.com/problems/rotate-string/
5. https://www.hackerrank.com/challenges/mars-exploration/problem
6. https://leetcode.com/problems/find-all-anagrams-in-a-string/
7. https://www.hackerrank.com/challenges/palindrome-index/problem
8. https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
9. https://leetcode.com/problems/longest-palindromic-substring/
10. https://www.hackerrank.com/challenges/circular-palindromes/problem
