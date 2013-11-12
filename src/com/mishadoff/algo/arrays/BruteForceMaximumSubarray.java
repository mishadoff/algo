package com.mishadoff.algo.arrays;

import java.util.Arrays;

/**
 * O(n^2)
 *
 * @author mishadoff
 */
public class BruteForceMaximumSubarray implements MaximumSubarray {

    @Override
    public int[] find(int[] array) {
        int leftBoundary = 0;
        int rightBoundary = 0;
        int maxSum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int curSum = 0;
            for (int j = i; j < array.length; j++) {
                curSum += array[j];
                if (curSum > maxSum) {
                    leftBoundary = i;
                    rightBoundary = j;
                    maxSum = curSum;
                }
            }
        }
        return (maxSum == 0) ? new int[0]
                             : Arrays.copyOfRange(array, leftBoundary, rightBoundary + 1);
    }

    // --------------------- TEST

    public static void main(String[] args) {
        MaximumSubarray problem = new BruteForceMaximumSubarray();
        int[] result = problem.find(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7});
        System.out.println(Arrays.toString(result));
    }
}
