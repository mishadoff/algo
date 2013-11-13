package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sorting by counting elements. Supports only elements in range [0..9]
 * because used as step in radix sort.
 *
 * Can be extended to support any limited set with size K,
 * but requires O(K) auxillary space
 *
 *
 * @author mishadoff
 */
public class CountingSort extends Sort {

    @Override
    public void sort(int[] a) {
        sort(a, 0);
    }

    public void sort(int[] a, int bit) {
        int[] aux = new int[10]; // supports only elements in range [0..9]
        int[] b = new int[a.length]; // result array

        for (int i = 0; i < a.length; i++) {
            aux[bit(a[i], bit)]++; // count number of elements
        }

        // building nondecreasing array
        for (int i = 1; i < aux.length; i++) {
            aux[i] += aux[i - 1];
        }

        // counts print
        for  (int j = a.length - 1; j >=0 ; j--) {
            int d = bit(a[j], bit);
            b[aux[d] - 1] = a[j];
            aux[d]--;
        }

        // modify original array
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }

    private int bit(int number, int bit) {
        int mod = 10;
        while (bit > 0) {
            mod *= 10;
            bit--;
        }
        return (number % mod) / (mod / 10);
    }

    public static void main(String[] args) {
        int[] a = ArrayUtils.random(10, 10);
        System.out.println(Arrays.toString(a));
        Sort sort = new CountingSort();
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
