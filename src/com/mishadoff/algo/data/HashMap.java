package com.mishadoff.algo.data;

/**
 * @author mishadoff
 */
public class HashMap<K, V> {
    private Entry<K, V> data[];
    private int size;
    private double loadFactor = 0.75;

    public HashMap() {
        data = new Entry[8];
        size = 0;
    }

    public void put(K key, V value) {
        int bucket = bucketIndex(key);

        Entry<K, V> e = new Entry<K, V>(key, value);
        if (data[bucket] == null) {
            data[bucket] = e;
            size++;
        } else { // append to the list
            Entry<K, V> next = data[bucket];
            Entry<K, V> prev = null;
            while (next != null) {
                if (next.key.equals(key)) {
                    next.value = value;
                    return; //
                }
                prev = next;
                next = next.next;
            }
            prev.next = e;
            size++;
        }
    }

    public V get(K key) {
        int bucket = bucketIndex(key);
        Entry<K, V> next = data[bucket];
        V result = null;
        while (next != null) {
            if (next.key.equals(key)) {
                result = next.value;
                break;
            }
            next = next.next;
        }
        return next == null ? null : result;
    }

    public void remove(K key) {
        int bucket = bucketIndex(key);
        Entry<K, V> next = data[bucket];
        Entry<K, V> prev = null;
        while (next != null) {
            if (next.key.equals(key)) {
                if (prev != null) {
                    prev.next = next.next;
                } else {
                    data[bucket] = next.next;
                }
                size--;
                break;
            }
            prev = next;
            next = next.next;
        }
    }

    public int size() {
        return size;
    }

    private void rehashIfNeeded() {
        if (size > data.length * loadFactor) {
            // TODO rehash
        }
    }

    /**
     * Simplest way to obtain array index for key
     * @param key
     * @return
     */
    private int bucketIndex(K key) {
        return ((key.hashCode() % data.length) + data.length) % data.length; // to avoid negative values
    }

    class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + i + "] =:= ");
            Entry<K, V> next = data[i];
            while (next != null) {
                System.out.print("[" + next.key + ", " + next.value + "] -> ");
                next = next.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("qwerty", "NUMBER");
        map.put("hello", "World");
        map.put("die", "DIE");
        map.put("taras", "Petrovich");
        map.put("qwerty", "ZELENKA");
        map.put("piko", "chu");
        map.put("lift", "bind");
        map.put("scala", "mal");
        map.put("clojure", "compojure1");
        map.put("clojure", "compojure2");
        map.put("clojure", "compojure3");
        map.put("clojure", "compojure4");
        map.put("qwerty", "Boo");
        map.put("Finita", "La Comedia");
        map.put("Cry", "Me A River");
        map.put("Justin", "Kills");
        map.put("Machete", "Kills");
        map.put("Django", "Unchained");
        map.put("The", "Godfather");
        map.put("Shawshunk", "Redemption");
        //System.out.println(map.get("qwerty"));
        //map.remove("ffff"); // FIXME remove not working!!!
        map.remove("Django");
        map.print();
        System.out.println(map.size());
        System.out.println(map.get("qwerty"));
    }

}
