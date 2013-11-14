package com.mishadoff.algo.utils;

import java.util.Random;

/**
 * @author mishadoff
 */
public final class ArrayUtils {
    private static Random r = new Random();

    private ArrayUtils() { }

    public static void shuffle(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int index = r.nextInt(i + 1);
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }

    public static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }

    public static boolean isSorted(int[] a) {
        boolean sorted = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public static int[] range(int end) {
        int[] result = new int[end];
        for (int i = 0; i < end; i++) {
            result[i] = i;
        }
        return result;
    }

    public static int[] random(int size) {
        return random(size, 100);
    }

    public static int[] random(int size, int max) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = r.nextInt(max);
        }
        return result;
    }

    public static int[] copy(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        return result;
    }

    public static void clear(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
    }
}
