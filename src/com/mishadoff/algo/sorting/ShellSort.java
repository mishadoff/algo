package com.mishadoff.algo.sorting;

/**
 * @author mishadoff
 */
public class ShellSort extends Sort {
    // Ciura gaps
    private int[] GAPS = {701, 301, 132, 57, 23, 10, 4, 1};

    @Override
    public void sort(int[] a) {
        for (int g : GAPS) {
            // do insertion sort for each gap
            for (int k = g; k < a.length; k++) {
                int current = a[k];
                int i = k - g;
                while (i >= 0 && a[i] > current) {
                    a[i + g] = a[i];
                    i -= g;
                }
                a[i + g] = current;
            }
        }
    }
}
