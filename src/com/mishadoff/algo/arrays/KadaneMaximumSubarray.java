package com.mishadoff.algo.arrays;

import java.util.Arrays;

/**
 * @author mishadoff
 */
public class KadaneMaximumSubarray implements MaximumSubarray {

    @Override
    public int[] find(int[] array) {
        if (array.length == 0) return new int[0];
        int startPosition = 0;
        int tempPos = 0;
        int endPosition = Integer.MIN_VALUE;
        int maxSoFar = array[0];
        int maxEndingHere = array[0];
        for (int i = 1; i < array.length; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = array[i];
                tempPos = i;
            } else {
                maxEndingHere += array[i];
            }

            if (maxEndingHere >= maxSoFar && maxEndingHere > 0) {
                maxSoFar = maxEndingHere;
                startPosition = tempPos;
                endPosition = i;
            }
        }
        return (endPosition == Integer.MIN_VALUE)
                    ? new int[0]
                    : Arrays.copyOfRange(array, startPosition, endPosition + 1);
    }

    // TEST -----------

    public static void main(String[] args) {
        MaximumSubarray max = new KadaneMaximumSubarray();
        int[] result = max.find(new int[] { -4, -2, -3, -4});
        System.out.println(Arrays.toString(result));
    }
}
