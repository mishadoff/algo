package com.mishadoff.algo.utils;

import java.util.Random;

/**
 * @author mishadoff
 */
public final class ArrayUtils {
    private static Random r = new Random();

    private ArrayUtils() { }

    public static <T> void shuffle(T[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int index = r.nextInt(i + 1);
            T temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }

    public static <T> void reverse(T[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            T temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }
}
