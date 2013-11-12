package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;
import com.mishadoff.algo.utils.GeneratorUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mishadoff
 */
public class BogoSortTest {

    private static final int DEFAULT_LIST_SIZE = 5;

    private Sort sort;

    @Before
    public void setUp() {
        sort = new BogoSort();
    }

    @Test
    public void bogoSortSortedIntegers() {
        Integer[] input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void bogoSortReverseSortedIntegers() {
        Integer[] input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        ArrayUtils.reverse(input);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void bogoSortShuffledIntegers() {
        Integer[] input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        ArrayUtils.shuffle(input);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void bogoSortStrings() {
        String[] input = Arrays.copyOfRange(GeneratorUtils.names(), 0, 5);
        ArrayUtils.shuffle(input);
        sort.sort(input, Comparators.STRING_COMPARATOR);
        Assert.assertEquals(input, Arrays.copyOfRange(GeneratorUtils.names(), 0, 5));
    }

}
