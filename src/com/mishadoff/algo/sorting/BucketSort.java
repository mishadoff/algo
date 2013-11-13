package com.mishadoff.algo.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author mishadoff
 */
public class BucketSort extends Sort{
    private int numOfBuckets;
    private int max;

    private ArrayList[] buckets;

    public BucketSort() {
        this(Integer.MAX_VALUE, 20);
    }

    public BucketSort(int max, int numOfBuckets) {
        this.max = max;
        this.numOfBuckets = numOfBuckets;
        buckets = new ArrayList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
    }

    @Override
    public void sort(int[] a) {
        // split array into buckets
        for (int i = 0; i < a.length; i++) {
            // detect bucket
            int bucketNum = (int)(a[i] * 1.0 * numOfBuckets / max);
            buckets[bucketNum].add(a[i]);
        }

        // sort each bucket separately
        for (int i = 0; i < numOfBuckets; i++) {
            Collections.sort(buckets[i]);
        }

        // copy from buckets back to array
        int orig = 0;
        for (int i = 0; i < numOfBuckets; i++) {
            ArrayList<Integer> bucket = buckets[i];
            for (Integer e : bucket) {
                a[orig] = e;
                orig++;
            }
        }
    }
}
