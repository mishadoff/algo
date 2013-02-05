package com.mishadoff.algo.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mishadoff.algo.sorting.Comparators;

public class BinarySearch implements Search {

	/**
	 * Input list must be sorted
	 */
	@Override
	public <T> int search(List<T> elem, T e) {
		throw new IllegalArgumentException("Call method with comparator!");
	}
	
	@Override
	public <T> int search(List<T> elem, T e, Comparator<T> comp) {
		return binarySearch(elem, e, 0, elem.size() - 1, comp);
	}

	private <T> int binarySearch(List<T> elem, T e, int a, int b, Comparator<T> comp) {
		if (b < a) {
			return NOT_FOUND;	// recursion stop condition
		} else {
			// split array in two parts
			int midPoint = (a + b) / 2;

			if (comp.compare(elem.get(midPoint), e) > 0) {					// mid element is greater
				return binarySearch(elem, e, a, midPoint - 1, comp);
			} else if (comp.compare(elem.get(midPoint), e) < 0) {			// mid element is smaller
				return binarySearch(elem, e, midPoint + 1, b, comp);
			} else {		// element is found
				return midPoint;
			}	
		}
	}
	
	// --------------------- TEST
	
	public static void main(String[] args) {
		Search search = new BinarySearch();
		List<String> names = Arrays.asList("alice", "bob", "eugene", "cindy", "valeriy", "chris", "stewart", "alla");
		// list must be sorted
		Collections.sort(names, Comparators.STRING_COMPARATOR);
		System.out.println("Names: " + names);
		String toFind = "cindy";
		System.out.println("Search for [" + toFind + "]: idx = " + search.search(names, toFind, Comparators.STRING_COMPARATOR));
		toFind = "alex";
		System.out.println("Search for [" + toFind + "]: idx = " + search.search(names, toFind, Comparators.STRING_COMPARATOR));
	}
}
