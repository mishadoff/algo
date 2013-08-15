package com.mishadoff.algo.smoothing;

import java.util.Arrays;

public class TestSmoothing {
    public static void main(String[] args) {
        double[] data = {5, 4, 4, 3, 4, 5, 6, 6, 5, 5, 6, 3, 4, 5, 7, 5};
        SMA sma3 = new SMA();
        System.out.println("=== SMA === [windowSize = 3]");
        System.out.println(Arrays.toString(sma3.smooth(data)));
        SMA sma5 = new SMA(5);
        System.out.println("=== SMA === [windowSize = 5]");
        System.out.println(Arrays.toString(sma5.smooth(data)));
        CMA cma3 = new CMA();
        System.out.println("=== CMA === [windowSize = 3]");
        System.out.println(Arrays.toString(cma3.smooth(data)));
        CMA cma5 = new CMA(5);
        System.out.println("=== CMA === [windowSize = 5]");
        System.out.println(Arrays.toString(cma5.smooth(data)));


    }
}
