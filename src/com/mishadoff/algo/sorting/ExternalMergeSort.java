package com.mishadoff.algo.sorting;

import com.mishadoff.algo.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author mishadoff
 */
public class ExternalMergeSort extends Sort {
    private int MEMORY_SIZE;

    public ExternalMergeSort(int memorySize) {
        this.MEMORY_SIZE = memorySize;
    }

    @Override
    public void sort(int[] a) {
        int numberOfChunks = (a.length - 1) / MEMORY_SIZE + 1;
        if (numberOfChunks >= MEMORY_SIZE) throw new IllegalArgumentException("Small amount of memory");

        // assuming a - array does not fit into memory
        int[] buffer = new int[MEMORY_SIZE];
        // external memory chunks
        ArrayList<int[]> chunks = new ArrayList<>();

        int arrayPointer = 0;
        int bufferPointer = 0;

        // read and sort all chunks
        while (arrayPointer < a.length) {
            // read chunk to buffer
            while (bufferPointer < buffer.length && arrayPointer < a.length) {
                buffer[bufferPointer] = a[arrayPointer];
                bufferPointer++;
                arrayPointer++;
            }
            // sort in buffer until buffer pointer
            Arrays.sort(buffer, 0, bufferPointer);
            // write sorted chunk to some storage
            chunks.add(Arrays.copyOfRange(buffer, 0, bufferPointer));
            bufferPointer = 0;
        }

        int n = chunks.size();
        int chunkInBufferSize = 0;
        int sortedBufferSize = 0;
        if (n == 1) { // one chunk fits to memory
            a = chunks.get(0);
            return;
        } else {
            chunkInBufferSize = MEMORY_SIZE / (n + 1);
            sortedBufferSize = MEMORY_SIZE - (n * chunkInBufferSize);
        }

        //System.out.println("Number of chunks:" + n);
        //System.out.println("Chunk in buffer size:" + chunkInBufferSize);
        //System.out.println("Sorted buffer size:" + sortedBufferSize);


        // assuming chunk pointers is external // need to be in memory
        int[] chunkPointers = new int[n];
        // initial chunks reading
        ArrayUtils.clear(buffer); // debug
        // print chunks
        /*for (int i = 0; i < n; i++) {
            System.out.println("Chunk [" + i + "]: " + Arrays.toString(chunks.get(i)));
        }
*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < chunkInBufferSize; j++) {
                buffer[i * chunkInBufferSize + j] = chunks.get(i)[chunkPointers[i]];
                chunkPointers[i]++;
            }
        }
        //System.out.println("Buffer:" + Arrays.toString(buffer));

        // n-way merge
        int[] chunkPointersInBuffer = new int[n];
        int[] nway = new int[n];
        int bufferSortedPointer = 0;
        int globalSortedPointer = 0;

        //ArrayUtils.clear(a); // debug

        for (int i = 0; i < a.length; i++) {
            for (int nwayIndex = 0; nwayIndex < n; nwayIndex++) {
                nway[nwayIndex] = buffer[nwayIndex * chunkInBufferSize + chunkPointersInBuffer[nwayIndex]];
            }
            //System.out.println("Nway: " + Arrays.toString(nway));
            // find min index in nway
            int minIndex = 0;
            for (int j = 1; j < n; j++) {
                if (nway[j] < nway[minIndex]) minIndex = j;
            }
          //  System.out.println("MinIndex: " + minIndex + ", MinValue: " + nway[minIndex]);

            chunkPointersInBuffer[minIndex]++;
            if (chunkPointersInBuffer[minIndex] == chunkInBufferSize) {
                // chunk is exhausted load next portion
              //  System.out.println("Chunk [" + minIndex + "] is exhausted, load new portion");
                int chunkLocalPointer = 0;
                for (chunkLocalPointer = 0; chunkLocalPointer < chunkInBufferSize &&
                                chunkPointers[minIndex] < chunks.get(minIndex).length; chunkLocalPointer++) {
                    buffer[minIndex * chunkInBufferSize + chunkLocalPointer] = chunks.get(minIndex)[chunkPointers[minIndex]];
                    chunkPointers[minIndex]++;
                }
                // at least one empty place in chunk buffer
                if (chunkLocalPointer < chunkInBufferSize) {
                    buffer[minIndex * chunkInBufferSize + chunkLocalPointer] = Integer.MAX_VALUE; // sentinel
                }
                chunkPointersInBuffer[minIndex] = 0;
                //System.out.println("Buffer:" + Arrays.toString(buffer));
            }

            // write min to buffer
            buffer[n * chunkInBufferSize + bufferSortedPointer] = nway[minIndex];
            bufferSortedPointer++;

            //System.out.println("Min to buffer: " + Arrays.toString(buffer));

            // check buffer is full
            if (bufferSortedPointer == sortedBufferSize) {
//                System.out.println("Buffer is full");
                // load buffer to array
                for (int k = 0; k < bufferSortedPointer; k++) {
                    a[globalSortedPointer] = buffer[n * chunkInBufferSize + k];
                    globalSortedPointer++;
                }
                bufferSortedPointer = 0;
                // todo exhausted number
  //              System.out.println("Resulted Array: " + Arrays.toString(a));
            }

        }

        // buffer still can hold some values
        for (int k = 0; k < bufferSortedPointer; k++) {
            a[globalSortedPointer] = buffer[n * chunkInBufferSize + k];
            globalSortedPointer++;
        }
    //    System.out.println("Last fill: " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        Sort sort = new ExternalMergeSort(30);
        int[] input = ArrayUtils.random(200);
        System.out.println(Arrays.toString(input));
        sort.sort(input);
        System.out.println(Arrays.toString(input));
        System.out.println(ArrayUtils.isSorted(input));
    }
}
