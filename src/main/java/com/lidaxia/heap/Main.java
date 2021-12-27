package com.lidaxia.heap;

import java.util.Arrays;
import java.util.Random;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/27 17:55
 */
public class Main {

    private static double testHeap(Integer[] testData, boolean isHeapfy) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;

        if (isHeapfy) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>(testData.length);
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < testData.length; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) {
        int n = 1000000;

        Integer[] testData = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);


        System.out.println("isHeapfy:" + testHeap(testData, true));
        System.out.println("not isHeapfy:" + testHeap(testData, false));
    }

}
