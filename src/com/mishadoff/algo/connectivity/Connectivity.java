package com.mishadoff.algo.connectivity;

/**
 * Common interface for dynamic connectivity problems.
 * @author mishadoff
 *
 */
public interface Connectivity {
	
	/**
	 * Connect component i to component j
	 */
	void union(int i, int j);
	
	/**
	 * Check whether component i connected to component j
	 * @return
	 */
	boolean isConnected(int i, int j);
}
