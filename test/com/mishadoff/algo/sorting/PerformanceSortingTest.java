package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.GeneratorUtils;
import com.mishadoff.algo.utils.Timer;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author mishadoff
 */
public class PerformanceSortingTest {

    private List<Integer> input;

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
    }

    private List<Integer> getSorted() {
        return GeneratorUtils.range(LIST_SIZE);
    }

    @Test
    public void testOnReverseSorted() {
        sortTest("Bubble Sort [Reverse Sorted] : ", new BubbleSort(), getReverseSorted());
        sortTest("Insertion Sort [Reverse Sorted] : ", new InsertionSort(), getReverseSorted());
        sortTest("Merge Sort [Reverse Sorted] : ", new MergeSort(), getReverseSorted());
        sortTest("Selection Sort [Reverse Sorted] : ", new SelectionSort(), getReverseSorted());
    }

    private List<Integer> getReverseSorted() {
        List<Integer> list = GeneratorUtils.range(LIST_SIZE);
        Collections.reverse(list);
        return list;
    }

    @Test
    public void testOnRandom() {
        sortTest("Bubble Sort [Random Sorted] : ", new BubbleSort(), getRandomSorted());
        sortTest("Insertion Sort [Random Sorted] : ", new InsertionSort(), getRandomSorted());
        sortTest("Merge Sort [Random Sorted] : ", new MergeSort(), getRandomSorted());
        sortTest("Selection Sort [Random Sorted] : ", new SelectionSort(), getRandomSorted());
    }

    private List<Integer> getRandomSorted() {
        List<Integer> list = GeneratorUtils.range(LIST_SIZE);
        Collections.shuffle(list);
        return list;
    }

    private void sortTest(String testMessage, Sort algorithm, List<Integer> input) {
        timer = new Timer();
        timer.start();
        algorithm.sort(input, Comparators.INTEGER_COMPARATOR);
        timer.stop();
        System.out.println(testMessage + " " + timer.getTime());
    }

}
