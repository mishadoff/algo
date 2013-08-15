package com.mishadoff.algo.smoothing;

/**
 * Centered Moving Average
 *
 * Averaging value by the neighbour n points. n must be odd
 *
 * @author mishadoff
 */
public class CMA {
    private int windowSize;

    public CMA() {
        this(3);
    }

    public CMA(int windowSize) {
        this.windowSize = windowSize;
    }

    public double[] smooth(double[] data) {
        double[] result = new double[data.length];
        // plain copy of first n/2 points
        // TODO can be handled more clever
        // TODO need "original" shifting
        for (int i = 0; i < windowSize / 2; i++) {
            result[i] = data[i];
        }

        for (int i = windowSize / 2; i < data.length - windowSize / 2; i++) {
            // averaging previous n points
            double sum = 0;
            for (int k = -windowSize/2; k <= windowSize/2; k++) {
                sum += data[i + k];
            }
            result[i] = sum / windowSize;
        }
        // plain copy of last n points
        for (int i = data.length - windowSize / 2; i < data.length; i++) {
            result[i] = data[i];
        }
        return result;
    }

}
