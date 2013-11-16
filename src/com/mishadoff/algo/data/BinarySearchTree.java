package com.mishadoff.algo.data;

/**
 * @author mishadoff
 */
public class BinarySearchTree<T> {
    Node root = null;

    BinarySearchTree() { }

    public void insert(int key, T value) {
        root = insert(root, key, value);
    }

    private Node<T> insert(Node<T> node, int key, T value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (node.key == key) {
            node.value = value;
        } else if (key < node.key) {
            node.left = insert(node.left, key, value);
        } else if (key > node.key) {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    public T find(int key) {
        Node<T> next = root;
        while (next != null) {
            if (key == next.key) return next.value;
            else if (key < next.key) next = next.left;
            else if (key > next.key) next = next.right;
        }
        return null;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public Node delete(Node<T> node, int key) {
        // search node
        if (node == null) return null;
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {

            // Deletion Case 1: If node children, just delete
            if (node.left == null && node.right == null) {
                return null;
            }

            // Deletion Case 2: Just one children
            if (node.left == null || node.right == null) {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;
            }

            // Deletion Case 3: Both children present
            // find node's successor
            Node<T> succ = node.right;
            while (succ.left != null) {
                succ = succ.left;
            }
            System.out.println("SUCC: " + succ.key);

            Node<T> nodeLeft = node.left;
            Node<T> nodeRight = null;
            if (node.right.key == succ.key) { // immidiately to the right
                nodeRight = succ.right;
            } else {
                nodeRight = removeSucc(node.right, succ);
            }

            succ.left = nodeLeft;
            succ.right = nodeRight;
            return succ;
        }
        return node;
    }

    private Node<T> removeSucc(Node<T> path, Node<T> succ) {
        if (succ.key == path.key) {
            return path.right;
        }
        path.left = removeSucc(path.left, succ);
        return path;
    }

    /* Different Traversal Strategies */

    public void inorder() {
        inorder(root);
        System.out.println("");
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.key + " -> ");
        inorder(node.right);
    }

    public void preorder() {
        preorder(root);
        System.out.println("");
    }

    private void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " -> ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder() {
        postorder(root);
        System.out.println("");
    }

    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key + " -> ");
    }

    public

    class Node<T> {
        int key;
        T value;
        Node<T> left;
        Node<T> right;

        Node(int key, T value) {
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert(16, "16");
        bst.insert(12, "12");
        bst.insert(24, "24");
        bst.insert(8, "8");
        bst.insert(19, "19");
        bst.insert(20, "20");
        bst.insert(28, "28");
        bst.insert(5, "5");
        bst.insert(11, "11");
        bst.insert(23, "23");
        bst.insert(30, "30");
        bst.insert(18, "18");
        bst.insert(21, "21");
        bst.insert(22, "22");
        //
        System.out.println(bst.find(8)); // soul
        System.out.println(bst.find(-1)); // null

        System.out.println("Inorder: "); bst.inorder();
        //System.out.println("Preorder: "); bst.preorder();
        //System.out.println("Postorder: "); bst.postorder();

        bst.delete(11);
        System.out.println("Inorder: "); bst.inorder();
        bst.delete(8);
        System.out.println("Inorder: "); bst.inorder();
        System.out.println("PRE: "); bst.preorder();
        bst.delete(20);
        System.out.println("PRE: "); bst.preorder();
        bst.delete(19);
        System.out.println("PRE: "); bst.preorder();


/*
        bst.delete(20);
        System.out.println("Inorder: "); bst.inorder();
        System.out.println("PRE: "); bst.preorder();
*/

    }
}
