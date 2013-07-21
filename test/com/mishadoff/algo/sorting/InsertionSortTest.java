package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.GeneratorUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author mishadoff
 */
public class InsertionSortTest {

    private static final int DEFAULT_LIST_SIZE = 10_000;

    private Sort sort;

    @Before
    public void setUp() {
        sort = new InsertionSort();
    }

    @Test
    public void insertionSortSortedIntegers() {
        List<Integer> input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void insertionSortReverseSortedIntegers() {
        List<Integer> input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        Collections.reverse(input);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void insetionSortShuffledIntegers() {
        List<Integer> input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        Collections.shuffle(input);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void insertionSortStrings() {
        List<String> input = GeneratorUtils.names();
        Collections.shuffle(input);
        sort.sort(input, Comparators.STRING_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.names());
    }

}
