package com.mishadoff.algo.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Common interface for all sorting algorithms.
 * Sort in place.
 * 
 * @author mishadoff
 *
 */
public interface Sort<T> {
	void sort(List<T> elem, Comparator<T> comp);
}
