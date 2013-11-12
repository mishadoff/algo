package com.mishadoff.algo.arrays;

import javafx.util.Pair;

import java.util.Arrays;

/**
 * @author mishadoff
 */
public class DivideAndConquerMaximumSubarray implements MaximumSubarray{

    // TODO use own tuples
    // TODO return indices of array instead of copy

    @Override
    public int[] find(int[] array) {
        Pair<int[], Integer> result = find(array, 0, array.length - 1);
        System.out.println(result.getValue());
        return result.getKey();
    }

    /**
     * Recursive function to find maximum subarray.
     * Returns a tuple, array and its sum.
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private Pair<int[], Integer> find(int[] array, int start, int end) {
        if (end - start > 0) {
            int mid = (start + end) / 2;

            Pair<int[], Integer> left = find(array, start, mid);
            Pair<int[], Integer> right = find(array, mid + 1, end);
            Pair<int[], Integer> midArray = findCrossing(array, start, mid, end);

            if (left.getValue() > right.getValue() && left.getValue() > midArray.getValue()) {
                return left;
            } else if (right.getValue() > left.getValue() && right.getValue() > midArray.getValue()) {
                return right;
            } else {
                return midArray;
            }
        } else {
            return array[start] < 0 ? new Pair<int[], Integer>(new int[0], 0)
                                    : new Pair<int[], Integer>(new int[]{array[start]}, array[start]);
        }
    }

    private Pair<int[], Integer> findCrossing(int[] array, int start, int mid, int end) {
        int maxSumLeft = 0;
        int startPosition = Integer.MIN_VALUE;
        int sum = 0;
        for (int k = mid; k >= start; k--) {
            sum += array[k];
            if (sum > maxSumLeft) {
                startPosition = k;
                maxSumLeft = sum;
            }
        }

        int maxSumRight = 0;
        int endPosition = Integer.MIN_VALUE;
        sum = 0;
        for (int k = mid + 1; k <= end; k++) {
            sum += array[k];
            if (sum > maxSumRight) {
                endPosition = k;
                maxSumRight = sum;
            }
        }

        int[] result = (startPosition == Integer.MIN_VALUE || endPosition == Integer.MIN_VALUE)
                ? new int[0]
                : Arrays.copyOfRange(array, startPosition, endPosition + 1);
        return new Pair<int[], Integer>(result, maxSumLeft + maxSumRight);
    }


    // TEST -----------

    public static void main(String[] args) {
        MaximumSubarray max = new DivideAndConquerMaximumSubarray();
        int[] result = max.find(new int[] { -1, -1, -2, -2});
        System.out.println(Arrays.toString(result));

        System.out.println();
    }
}
