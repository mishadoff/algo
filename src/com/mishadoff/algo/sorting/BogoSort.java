package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;

/**
 * BogoSort is very ineffective sorting algorithm with O(Infinity) worst case.
 * Average is O(n * n!)
 *
 * WARNING: DONT USE IT IN PRACTICE, JUST FOR DEMONSTRATION PURPOSES
 * 
 * @author mishadoff
 *
 */
public class BogoSort extends Sort {

    @Override
	public void sort(int[] a) {
		while (!ArrayUtils.isSorted(a)) {
			ArrayUtils.shuffle(a);
		}
	}
}
