package com.mishadoff.algo.arrays;

import com.mishadoff.algo.utils.GeneratorUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author mishadoff
 */
public class MaximumSubarrayTest {

    @Test
    public void testBruteforce() {
        MaximumSubarray problem = new BruteForceMaximumSubarray();
        int[] result = problem.find(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7});
        Assert.assertArrayEquals(result, new int[]{18, 20, -7, 12});
    }

    @Test
    public void testBruteforcePositive() {
        MaximumSubarray problem = new BruteForceMaximumSubarray();
        int[] result = problem.find(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assert.assertArrayEquals(result, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    @Test
    public void testBruteforceNegative() {
        MaximumSubarray problem = new BruteForceMaximumSubarray();
        int[] result = problem.find(new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9});
        Assert.assertArrayEquals(result, new int[0]);
    }

}
