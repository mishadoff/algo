package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mishadoff
 */
public class SortTest {

    private static final int SIZE = 10_000;

    private Sort[] sorts;

    @Before
    public void setUp() {
        sorts = new Sort[] {
            new SelectionSort(),
            new BubbleSort(),
            new QuickSort(),
            new MergeSort(),
            new InsertionSort(),
            new HeapSort(),
            new RadixSort(),
            new BucketSort(10000, 20),
            new ExternalMergeSort(200),
            new ShellSort()
        };
    }

    @Test
    public void sortSortedIntegers() {
        for (Sort sort : sorts) {
            String sortMessage = "" + sort.getClass().getSimpleName();
            int[] input = ArrayUtils.range(SIZE);
            sort.sort(input);
            Assert.assertArrayEquals(sortMessage, input, ArrayUtils.range(SIZE));
        }
    }

    @Test
    public void sortReverseSortedIntegers() {
        for (Sort sort : sorts) {
            String sortMessage = "" + sort.getClass().getSimpleName();
            int[] input = ArrayUtils.range(SIZE);
            ArrayUtils.reverse(input);
            sort.sort(input);
            Assert.assertArrayEquals(sortMessage, input, ArrayUtils.range(SIZE));
        }
    }

    @Test
    public void sortShuffledDistinctIntegers() {
        for (Sort sort : sorts) {
            String sortMessage = "" + sort.getClass().getSimpleName();
            int[] input = ArrayUtils.range(SIZE);
            ArrayUtils.shuffle(input);
            sort.sort(input);
            Assert.assertArrayEquals(sortMessage, input, ArrayUtils.range(SIZE));
        }
    }

    @Test
    public void sortRandomIntegers() {
        for (Sort sort : sorts) {
            String sortMessage = "" + sort.getClass().getSimpleName();
            int[] input = ArrayUtils.random(SIZE);
            sort.sort(input);
            Assert.assertTrue(sortMessage, ArrayUtils.isSorted(input));
        }
    }

    @Test
    public void sortAllEqual() {
        int[] original = ArrayUtils.random(SIZE);
        int[] prev = null;

        for (Sort sort : sorts) {
            String sortMessage = "" + sort.getClass().getSimpleName();
            int[] newArray = ArrayUtils.copy(original);
            sort.sort(newArray);
            if (prev != null) { // skip assert for first time
                Assert.assertArrayEquals(sortMessage, newArray, prev);
            }
            prev = newArray;
        }
    }
}
