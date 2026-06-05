# Generic Binary Search Tree in Java

This repository contains an efficient, generic Binary Search Tree (BST) implementation written in Java. It was created to demonstrate fundamental data structures, clean code practices, and object-oriented principles.

## Key Features
* **Generics (`<T extends Comparable<T>>`):** This tree is not limited to integers. It can store strings, dates, or any custom objects that implement the `Comparable` interface.
* **Encapsulation:** The internal `Node` class is strictly private, ensuring the user only interacts with a clean, simple public API.
* **Clean Recursion:** A strict separation between public methods and private recursive helper methods.
* **Core Operations:** Includes Insertion, Searching, Deletion, and Inorder Traversal.

## Time Complexity
* **Average Case:** O(log n) for search, insert, and delete operations.
* **Worst Case:** O(n) (in the event the tree becomes highly skewed).
