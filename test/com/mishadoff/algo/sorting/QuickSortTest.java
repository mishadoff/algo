package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;
import com.mishadoff.algo.utils.GeneratorUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mishadoff
 */
public class QuickSortTest {

    private static final int DEFAULT_LIST_SIZE = 10_000;

    private Sort sort;

    @Before
    public void setUp() {
        sort = new QuickSort();
    }

    @Test
    public void quickSortSortedIntegers() {
        Integer[] input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void quickSortReverseSortedIntegers() {
        Integer[] input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        ArrayUtils.reverse(input);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void quickSortShuffledIntegers() {
        Integer[] input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        ArrayUtils.shuffle(input);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void quickSortStrings() {
        String[] input = GeneratorUtils.names();
        ArrayUtils.shuffle(input);
        sort.sort(input, Comparators.STRING_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.names());
    }
}
