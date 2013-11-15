package com.mishadoff.algo.data;

/**
 * @author mishadoff
 */
public class SinglyLinkedList {

    private int size; // size - O(1) time complexity instead of O(n);
    private Node root;

    public SinglyLinkedList() {
        this.size = 0;
        root = null;
    }

    public Node root() {
        return root;
    }

    void append(int e) {
        if (root == null) {
            root = new Node(e);
        } else {
            root.next = new Node(e);
        }
    }

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
