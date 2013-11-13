package com.mishadoff.algo.sorting;

/**
 * @author mishadoff
 */
public class QuickSort extends Sort {

    @Override
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int start, int end) {
        if (end - start > 0) {
            // select pivot
            int pivotIndex = selectPivot(a, start, end);
            int pivotValue = a[pivotIndex];
            // partitioning around the pivot
            int rightSide = end;
            int leftSide = start;
            while (leftSide <= rightSide) {
                if (a[leftSide] < pivotValue) {
                    leftSide++;
                } else if (a[rightSide] > pivotValue) {
                    rightSide--;
                } else {
                    swap(a, leftSide, rightSide);
                    rightSide--;
                    leftSide++;
                }
            }
            quickSort(a, start, rightSide);
            quickSort(a, leftSide, end);
        }
    }

    private int selectPivot(int[] a, int start, int end) {
        int midIdx = (start + end) / 2;
        int left = a[start];
        int mid = a[midIdx];
        int right = a[end];
        // middle from three elements // TODO extract to util
        if (left > mid) {
            if (mid > right) {
                return midIdx;
            } else if (left > right) {
                return end;
            } else {
                return start;
            }
        } else {
            if (left > right) {
                return start;
            } else if (mid > right) {
                return end;
            } else {
                return midIdx;
            }
        }
    }
}
