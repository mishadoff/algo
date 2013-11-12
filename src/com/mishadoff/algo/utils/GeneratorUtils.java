package com.mishadoff.algo.utils;

import java.util.*;

/**
 * @author mishadoff
 */
public final class GeneratorUtils {

    private GeneratorUtils() { }

    public static Integer[] range(int end) {
        Integer[] result = new Integer[end];
        for (int i = 0; i < end; i++) {
            result[i] = i;
        }
        return result;
    }

    public static String[] names() {
        return new String[] {
            "Alice", "Bob", "Cindy", "Derek", "Eugene", "Fred", "Garry",
            "Helen", "Ivan", "Jennifer", "Karl", "Lenny", "Margaret",
            "Nina", "Orwell", "Pete", "Quake", "Ryan", "Steve", "Tom",
            "Ulrich", "Vader", "Wayne", "Xen", "Yvonne", "Zorro"
        };
    }

}
