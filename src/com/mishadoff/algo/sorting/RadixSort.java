package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;

import java.util.Arrays;

/**
 * Works correctly only for positive numbers.
 *
 * @author mishadoff
 */
public class RadixSort extends Sort {
    @Override
    public void sort(int[] a) {
        // find max
        int max = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }

        // find number of digits in number
        int cnt = 0;
        while (max > 0) {
            max /= 10;
            cnt++;
        }

        CountingSort sort = new CountingSort();
        for (int i = 0; i < cnt; i++) {
            sort.sort(a, i);
        }
    }

    public static void main(String[] args) {
        int[] a = ArrayUtils.random(100);
        System.out.println(Arrays.toString(a));
        Sort sort = new RadixSort();
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
