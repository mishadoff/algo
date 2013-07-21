package com.mishadoff.algo.utils;

/**
 * Simplifies elapsed time calculation.
 *
 * @author mishadoff
 */
public class Timer {

    private long startTime;
    private long stopTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        stopTime = System.currentTimeMillis();
    }

    public long getTime() {
        return stopTime - startTime;
    }

}
