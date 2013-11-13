package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;
import com.mishadoff.algo.utils.Timer;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mishadoff
 */
public class PerformanceSortingTest {

    // Configuration
    private static final int SIZE = 10_000;
    private Sort[] sorts;

    // Time measurement
    private Timer timer;

    // TODO implement number of tests

    @Before
    public void setUp() {
        sorts = new Sort[] {
                new SelectionSort(),
                new BubbleSort(),
                new QuickSort(),
                new MergeSort(),
                new InsertionSort(),
                new HeapSort()
        };
    }

    @Test
    public void testOnSorted() {
        testInput("[Sorted]", getSorted());
    }

    private int[] getSorted() {
        return ArrayUtils.range(SIZE);
    }

    @Test
    public void testOnReverseSorted() {
        testInput("[Reverse Sorted]", getReverseSorted());
    }

    private int[] getReverseSorted() {
        int[] a = ArrayUtils.range(SIZE);
        ArrayUtils.reverse(a);
        return a;
    }

    @Test
    public void testOnRandomDistinct() {
        testInput("[Random Distinct]", getRandomDistinct());
    }

    private int[] getRandomDistinct() {
        int[] a = ArrayUtils.range(SIZE);
        ArrayUtils.shuffle(a);
        return a;
    }

    @Test
    public void testOnRandom() {
        testInput("[Random]", getRandom());
    }

    private int[] getRandom() {
        int[] a = ArrayUtils.range(SIZE);
        ArrayUtils.shuffle(a);
        return a;
    }

    private void sortTest(String testMessage, Sort algorithm, int[] input) {
        timer = new Timer();
        timer.start();
        algorithm.sort(input);
        timer.stop();
        System.out.println(testMessage + " " + timer.getTime());
    }

    private void testInput(String message, int[] input) {
        for (Sort sort : sorts) {
            int[] copy = ArrayUtils.copy(input);
            String sortMessage = sort.getClass().getSimpleName() + " " + message + ": ";
            sortTest(sortMessage, sort, copy);
        }
        System.out.println("");
    }

}
