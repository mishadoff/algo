package com.mishadoff.algo.sorting;

import java.util.Comparator;

/**
 * Class contains different comparators
 * @author mishadoff
 *
 */
public final class Comparators {
	private Comparators() { }
	
	/* Integer comparator */
	public final static Comparator<Integer> INTEGER_COMPARATOR = (a, b) -> a > b ? 1 : a < b ? -1 : 0;
	/* Integer reverse comparator */
	public final static Comparator<Integer> INTEGER_COMPARATOR_REVERSE =  (b, a) -> a > b ? 1 : a < b ? -1 : 0;
	/* String case sensitive comparator */
	public final static Comparator<String> STRING_COMPARATOR = (a, b) -> a.compareTo(b);
    /* String reverse case sensitive */
	public final static Comparator<String> STRING_COMPARATOR_REVERSE = (a, b) -> b.compareTo(a);
	/* String case insensitive comparator */
	public final static Comparator<String> STRING_COMPARATOR_CASE_INSENSITIVE = (a, b) -> a.compareToIgnoreCase(b);
}
