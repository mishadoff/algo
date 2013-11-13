package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;
import com.mishadoff.algo.utils.GeneratorUtils;
import com.mishadoff.algo.utils.Timer;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author mishadoff
 */
public class PerformanceSortingTest {

    // Configuration
    private static final int LIST_SIZE = 10000;

    // Time measurement
    private Timer timer;

    // TODO implement number of tests

    @Test
    public void testOnSorted() {
        sortTest("Bubble Sort [Sorted] : ", new BubbleSort(), getSorted());
        sortTest("Insertion Sort [Sorted] : ", new InsertionSort(), getSorted());
        sortTest("Merge Sort [Sorted] : ", new MergeSort(), getSorted());
        sortTest("Selection Sort [Sorted] : ", new SelectionSort(), getSorted());
        sortTest("Heap Sort [Sorted] : ", new HeapSort(), getSorted());
        sortTest("Quick Sort [Sorted] : ", new QuickSort(), getSorted());
    }

    private Integer[] getSorted() {
        return GeneratorUtils.range(LIST_SIZE);
    }

    @Test
    public void testOnReverseSorted() {
        sortTest("Bubble Sort [Reverse Sorted] : ", new BubbleSort(), getReverseSorted());
        sortTest("Insertion Sort [Reverse Sorted] : ", new InsertionSort(), getReverseSorted());
        sortTest("Merge Sort [Reverse Sorted] : ", new MergeSort(), getReverseSorted());
        sortTest("Selection Sort [Reverse Sorted] : ", new SelectionSort(), getReverseSorted());
        sortTest("Heap Sort [Reverse Sorted] : ", new HeapSort(), getReverseSorted());
        sortTest("Quick Sort [Reverse Sorted] : ", new QuickSort(), getReverseSorted());
    }

    private Integer[] getReverseSorted() {
        Integer[] a = GeneratorUtils.range(LIST_SIZE);
        ArrayUtils.reverse(a);
        return a;
    }

    @Test
    public void testOnRandom() {
        sortTest("Bubble Sort [Random Sorted] : ", new BubbleSort(), getRandomSorted());
        sortTest("Insertion Sort [Random Sorted] : ", new InsertionSort(), getRandomSorted());
        sortTest("Merge Sort [Random Sorted] : ", new MergeSort(), getRandomSorted());
        sortTest("Selection Sort [Random Sorted] : ", new SelectionSort(), getRandomSorted());
        sortTest("Heap Sort [Random Sorted] : ", new HeapSort(), getRandomSorted());
        sortTest("Quick Sort [Random Sorted] : ", new QuickSort(), getRandomSorted());
    }

    private Integer[] getRandomSorted() {
        Integer[] a = GeneratorUtils.range(LIST_SIZE);
        ArrayUtils.shuffle(a);
        return a;
    }

    private void sortTest(String testMessage, Sort algorithm, Integer[] input) {
        timer = new Timer();
        timer.start();
        algorithm.sort(input);
        timer.stop();
        System.out.println(testMessage + " " + timer.getTime());
    }

}
