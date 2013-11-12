package com.mishadoff.algo.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LinearSearch implements Search {

	@Override
	public <T> int search(T[] elem, T e) {
		int idx = NOT_FOUND;
		for (int i = 0; i < elem.length; i++) {
			if (elem[i].equals(e)) {
				idx = i;
				break;
			} 
		}
		return idx;
	}
	
	@Override
	public <T> int search(T[] elem, T e, Comparator<T> comp) {
		return search(elem, e);		// linear search not uses comparator
	}
	
	// --------------------- TEST
	
	public static void main(String[] args) {
		Search search = new LinearSearch();
		String[] names = {"alice", "bob", "cindy", "derek", "eugene", "cindy"};
		System.out.println("Names: " + Arrays.toString(names));
		String toFind = "cindy";
		System.out.println("Search for [" + toFind + "]: idx = " + search.search(names, toFind));
		toFind = "alex";
		System.out.println("Search for [" + toFind + "]: idx = " + search.search(names, toFind));
	}
}
