package com.mishadoff.algo.sorting;

import java.util.Comparator;

/**
 * Class contains different comparators
 * @author mishadoff
 *
 */
public final class Comparators {
	private  Comparators() { 	}
	
	/* Integer comparator */
	public final static Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return (o1 > o2) ? 1 : o1 < o2 ? -1 : 0;
		}
	};
	
	/* Integer reverse comparator */
	public final static Comparator<Integer> INTEGER_COMPARATOR_REVERSE = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return (o2 > o1) ? 1 : o2 < o1 ? -1 : 0;
		}
	};
}
