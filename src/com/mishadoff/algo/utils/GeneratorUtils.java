package com.mishadoff.algo.utils;

import java.util.*;

/**
 * @author mishadoff
 */
public final class GeneratorUtils {

    private GeneratorUtils() { }

    public static List<Integer> range(int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < end; i++) {
            result.add(i);
        }
        return result;
    }

    public static List<String> names() {
        return Arrays.asList(
            "Alice", "Bob", "Cindy", "Derek", "Eugene", "Fred", "Garry",
            "Helen", "Ivan", "Jennifer", "Karl", "Lenny", "Margaret",
            "Nina", "Orwell", "Pete", "Quake", "Ryan", "Steve", "Tom",
            "Ulrich", "Vader", "Wayne", "Xen", "Yvonne", "Zorro"
        );
    }

}
