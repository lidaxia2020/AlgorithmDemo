package com.lidaxia.sort;

/**
 * 计数排序
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/11 11:50（
 */
public class CountingSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) {

        int maxValue = getMaxValue(sourceArray);

        return countingSort(sourceArray, maxValue);
    }

    private int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
