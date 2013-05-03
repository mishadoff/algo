package com.mishadoff.algo.numeric;

public interface Sequence<T> {
	T next();
	int currentIdx();
	void reset();
}