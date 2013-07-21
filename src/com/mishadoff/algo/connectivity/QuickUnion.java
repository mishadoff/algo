package com.mishadoff.algo.connectivity;

/**
 * Improved algorithm for connectivity problem.
 * 
 * Compexity:
 * union O(n)
 * isConnected O(n)
 * 
 * @author mishadoff
 *
 */
public class QuickUnion implements Connectivity {
    
    private int[] connections;
    
    public QuickUnion(int N) {
        connections = new int[N];
        for (int i = 0; i < N; i++) {
            connections[i] = i;
        }
    }
    
    @Override
    public void union(int i, int j) {
        int first = findRoot(i);
        int second = findRoot(j);
        connections[first] = second;
    }
    
    @Override
    public boolean isConnected(int i, int j) {
        return findRoot(i) == findRoot(j);
    }
    
    /**
     * Return root component id for passed one.
     * @param i
     * @return
     */
    private int findRoot(int i) {
        while (i != connections[i]) {
            i = connections[i];
        }
        return i;
    }
    
    // --------------------- TEST
    public static void main(String[] args) {
        Connectivity con = new QuickUnion(10);
        //6-3 3-7 4-0 3-8 9-6 5-0
            con.union(6, 3);
            con.union(3, 7);
            con.union(4, 0);
            con.union(3, 8);
            con.union(9, 6);
            con.union(5, 0);
            con.union(5, 1);
        System.out.println(con.isConnected(0, 3));
    }
}
