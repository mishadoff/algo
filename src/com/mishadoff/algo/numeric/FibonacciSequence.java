package com.mishadoff.algo.numeric;

import java.math.BigInteger;

public class FibonacciSequence implements Sequence<BigInteger> {
	private BigInteger prev1 = BigInteger.ONE;
	private BigInteger prev2 = BigInteger.ONE;
	
	private int currentIdx = 0;
	
	@Override
	public int currentIdx() {
		return this.currentIdx;
	}
	
	@Override
	public void reset() {
		this.currentIdx = 0;
	}
	
	public BigInteger next() {
		if (currentIdx < 2) {
			currentIdx++;
			return BigInteger.ONE;
		}
		BigInteger result = prev1.add(prev2);
			prev1 = prev2;
			prev2 = result;
		return result;
	}
}
