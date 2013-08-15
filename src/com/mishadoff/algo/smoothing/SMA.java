package com.mishadoff.algo.smoothing;

/**
 * Simple Moving Average
 *
 * Averaging value by the previous n-points. n must be odd
 *
 * @author mishadoff
 */
public class SMA {
    private int windowSize;

    public SMA() {
        this(3);
    }

    public SMA(int windowSize) {
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
