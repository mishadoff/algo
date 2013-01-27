package com.mishadoff.algo.search;

import java.util.Arrays;
import java.util.List;

public class LinearSearch implements Search {

	@Override
	public <T> int search(List<T> elem, T e) {
		int idx = -1; // init index as not found yet
		for (int i = 0; i < elem.size(); i++) {
			if (elem.get(i).equals(e)) {
				idx = i;
				break;
			} 
		}
		return idx;
	}
	
	public static void main(String[] args) {
		Search search = new LinearSearch();
		List<String> names = Arrays.asList("alice", "bob", "cindy", "derek", "eugene", "cindy");
		System.out.println("Names: " + names);
		String toFind = "cindy";
		System.out.println("Search for [" + toFind + "]: idx = " + search.search(names, toFind));
		toFind = "alex";
		System.out.println("Search for [" + toFind + "]: idx = " + search.search(names, toFind));
	}
}
