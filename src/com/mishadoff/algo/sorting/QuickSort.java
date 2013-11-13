package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;
import com.mishadoff.algo.utils.GeneratorUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mishadoff
 */
public class QuickSort extends Sort {
    @Override
    public <T> void sort(T[] a, Comparator<T> comp) {
        quickSort(a, 0, a.length - 1, comp);
    }

    private <T> void quickSort(T[] a, int start, int end, Comparator<T> comp) {
        if (end - start > 0) {
            // select pivot
            int pivotIndex = selectPivot(a, start, end, comp);
            T pivotValue = a[pivotIndex];
            // partitioning around the pivot
            int rightSide = end;
            int leftSide = start;
            while (leftSide <= rightSide) {
                if (comp.compare(a[leftSide], pivotValue) < 0) {
                    leftSide++;
                } else if (comp.compare(a[rightSide], pivotValue) > 0) {
                    rightSide--;
                } else {
                    T temp = a[leftSide];
                    a[leftSide] = a[rightSide];
                    a[rightSide] = temp;
                    rightSide--;
                    leftSide++;
                }
            }
            quickSort(a, start, rightSide, comp);
            quickSort(a, leftSide, end, comp);
        }
    }

    private <T> int selectPivot(T[] a, int start, int end, Comparator<T> comp) {
        // TODO clever pivot selection
        return (start + end) / 2;
    }

    // TEST ------------

    public static void main(String[] args) {
        Sort sort = new QuickSort();
        Integer[] array = GeneratorUtils.range(4);
        ArrayUtils.shuffle(array);
        System.out.println(Arrays.toString(array));
        sort.sort(array);
        Arrays.toString(array);
        System.out.println(Arrays.toString(array));
    }
}
