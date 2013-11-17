package com.mishadoff.algo.graphs;

import java.util.*;

/**
 * Simple graph structure represented as objects and pointers
 *
 * @author mishadoff
 */
public class Graph {
    HashMap<String, V> vertices = new HashMap<>();

    public Graph() { }

    public void add(V vertice) {
        vertices.put(vertice.name, vertice);
    }

    public void bfs(String vName) {
        V start = vertices.get(vName);
        if (start == null) throw new RuntimeException("No such vertice in a graph");
        // bfs
        HashSet<String> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<V>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            V node = queue.poll();
            System.out.print(node.name + " -> ");
            visited.add(node.name);
            List<V> children = node.adjacent;
            for (V child: children) {
                if (!visited.contains(child.name)) {
                    queue.offer(child);
                    visited.add(child.name);
                }
            }
        }
    }

    public void dfs(String vName) {
        V start = vertices.get(vName);
        if (start == null) throw new RuntimeException("No such vertice in a graph");
        // bfs
        HashSet<String> visited = new HashSet<>();
        dfs(start, visited);
    }

    private void dfs(V v, HashSet<String> visited) {
        System.out.print(v.name + " -> ");
        visited.add(v.name);
        List<V> children = v.adjacent;
            for (V child: children) {
                if (!visited.contains(child.name)) {
                    dfs(child, visited);
                    //visited.add(child.name);
                }
            }
        }

    static class V {
        String name;
        List<V> adjacent = new ArrayList<>();

        V(String name) {
            this.name = name;
        }

        void link(V another) {
            adjacent.add(another);
            another.adjacent.add(this);
        }
    }

    // TEST

    public static void main(String[] args) {
        Graph graph = new Graph();
        // creating vertices
        V a = new V("A");
        V b = new V("B");
        V c = new V("C");
        V d = new V("D");
        V e = new V("E");
        V f = new V("F");
        V g = new V("G");
        // link them
        a.link(b); a.link(c);
        b.link(c); b.link(d); b.link(e);
        c.link(e);
        d.link(e); d.link(f);
        e.link(f);
        f.link(g);
        // add to graph
        graph.add(a); graph.add(b); graph.add(c); graph.add(d);
        graph.add(e); graph.add(f); graph.add(g);

        System.out.println("BFS: ");
        graph.bfs("A");
        System.out.println("DFS: ");
        graph.dfs("A");

    }
}
