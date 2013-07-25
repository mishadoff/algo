package com.mishadoff.algo.numeric;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence implements Sequence<BigInteger> {
	private BigInteger prev1 = BigInteger.ONE;
	private BigInteger prev2 = BigInteger.ONE;
	
	private int currentIdx = 0;

	public BigInteger next() {
		if (currentIdx < 2) {
            currentIdx++;
			return BigInteger.ONE;
		}
		BigInteger result = prev1.add(prev2);
			prev1 = prev2;
			prev2 = result;
			currentIdx++;
		return result;
	}

    @Override
    public void drop(int n) {
        for (int i = 0; i < n ; i++) {
            next();
        }
    }

    @Override
    public List<BigInteger> take(int n) {
        List<BigInteger> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(next());
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// usage example
		Sequence seq = new FibonacciSequence();
		for (int i = 0; i < 10; i++) {
			System.out.println(seq.next());
		}

        seq.drop(10);
        System.out.println(seq.take(10));
    }
}
