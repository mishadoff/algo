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
public class BogoSortTest {

    private static final int DEFAULT_LIST_SIZE = 5;

    private Sort sort;

    @Before
    public void setUp() {
        sort = new BogoSort();
    }

    @Test
    public void bogoSortSortedIntegers() {
        List<Integer> input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void bogoSortReverseSortedIntegers() {
        List<Integer> input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        Collections.reverse(input);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void bogoSortShuffledIntegers() {
        List<Integer> input = GeneratorUtils.range(DEFAULT_LIST_SIZE);
        Collections.shuffle(input);
        sort.sort(input, Comparators.INTEGER_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.range(DEFAULT_LIST_SIZE));
    }

    @Test
    public void bogoSortStrings() {
        List<String> input = GeneratorUtils.names().subList(0, 5);
        Collections.shuffle(input);
        sort.sort(input, Comparators.STRING_COMPARATOR);
        Assert.assertEquals(input, GeneratorUtils.names().subList(0, 5));
    }

}
