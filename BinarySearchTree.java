/**
 * A Generic Binary Search Tree (BST) implementation in Java.
 * This structure provides efficient insertion, deletion, and search operations.
 * * Average Time Complexity: O(log n)
 * Worst Case Time Complexity: O(n) (in case of an unbalanced/skewed tree)
 *
 * @param <T> The type of elements held in this tree. Must implement Comparable.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * Inner class representing a node in the BST.
     */
    private class Node {
        T data;
        Node left, right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    /**
     * Constructor to initialize an empty BST.
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /* =========================================
     * INSERTION
     * ========================================= */

    /**
     * Inserts a new element into the BST.
     * @param data The data to be inserted.
     */
    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, T data) {
        // If the tree/subtree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        
        // Return the unchanged node pointer
        return root;
    }

    /* =========================================
     * SEARCHING
     * ========================================= */

    /**
     * Searches for a specific element in the BST.
     * @param data The element to search for.
     * @return true if the element exists, false otherwise.
     */
    public boolean search(T data) {
        return searchRec(root, data) != null;
    }

    private Node searchRec(Node root, T data) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.data.equals(data)) {
            return root;
        }

        // Key is greater than root's key
        if (root.data.compareTo(data) < 0) {
            return searchRec(root.right, data);
        }

        // Key is smaller than root's key
        return searchRec(root.left, data);
    }

    /* =========================================
     * DELETION
     * ========================================= */

    /**
     * Deletes an element from the BST.
     * @param data The element to be deleted.
     */
    public void delete(T data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, T data) {
        // Base case: If the tree is empty
        if (root == null) {
            return null;
        }

        // Recur down the tree
        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node to be deleted found

            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    /**
     * Finds the minimum value in a given subtree.
     */
    private T minValue(Node root) {
        T minVal = root.data;
        while (root.left != null) {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

    /* =========================================
     * TRAVERSAL
     * ========================================= */

    /**
     * Performs an Inorder traversal (Left, Root, Right).
     * This will print the elements in ascending sorted order.
     */
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
}
