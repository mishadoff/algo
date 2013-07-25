package com.mishadoff.algo.numeric;

import java.util.List;

public interface Sequence<T> {
	T next();

    void drop(int n);
    List<T> take(int n);
}