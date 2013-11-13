package com.mishadoff.algo.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mishadoff
 */
public class MaximumSubarrayTest {

    private MaximumSubarray[] algorithms;

    @Before
    public void setUp() {
        algorithms = new MaximumSubarray[] {
            new BruteForceMaximumSubarray(),
            new DivideAndConquerMaximumSubarray(),
            new KadaneMaximumSubarray(),
        };
    }

    @Test
    public void testBruteforce() {
        for (MaximumSubarray algo : algorithms) {
            String algoMessage = algo.getClass().getSimpleName();
            int[] result = algo.find(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7});
            Assert.assertArrayEquals(algoMessage, result, new int[]{18, 20, -7, 12});
        }
    }

    @Test
    public void testBruteforcePositive() {
        for (MaximumSubarray algo : algorithms) {
            String algoMessage = algo.getClass().getSimpleName();
            int[] result = algo.find(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            Assert.assertArrayEquals(result, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        }
    }

    @Test
    public void testBruteforceNegative() {
        for (MaximumSubarray algo : algorithms) {
            String algoMessage = algo.getClass().getSimpleName();
            int[] result = algo.find(new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9});
            Assert.assertArrayEquals(result, new int[0]);
        }
    }

}
