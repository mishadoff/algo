package com.mishadoff.algo.smoothing;

/**
 * Weighted Moving Average
 *
 * Averaging value by the neighbour n-points. n must be odd
 *
 * @author mishadoff
 */
public class WMA {
    private int windowSize;

    public WMA() {
        this(3);
    }

    public WMA(int windowSize) {
        this.windowSize = windowSize;
    }

    public double[] smooth(double[] data) {
        double[] result = new double[data.length];
        // plain copy of first n points
        // TODO can be handled more clever
        // TODO need "original" shifting
        for (int i = 0; i < windowSize - 1; i++) {
            result[i] = data[i];
        }

        for (int i = windowSize - 1; i < data.length; i++) {
            // averaging previous n points
            double sum = 0;
            for (int k = 0; k < windowSize; k++) {
                sum += data[i - k];
            }
            result[i] = sum / windowSize;
        }
        return result;
    }

}
