package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.GeneratorUtils;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author mishadoff
 */
public class SortUtilsTest {

    @Test
    public void testSorted() {
        Assert.assertTrue(SortUtils.isSorted(GeneratorUtils.range(10), Comparators.INTEGER_COMPARATOR));
        Assert.assertTrue(SortUtils.isSorted(GeneratorUtils.names(), Comparators.STRING_COMPARATOR));
        Assert.assertFalse(SortUtils.isSorted(Arrays.asList(2, 1, 4), Comparators.INTEGER_COMPARATOR_REVERSE));
    }
}
