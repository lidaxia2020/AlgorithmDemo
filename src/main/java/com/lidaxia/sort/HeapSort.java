package com.lidaxia.sort;

/**
 * 堆排序
 *
 * @author lijiannan
 * @desc
 * @date 2022/1/11 11:47（
 */
public class HeapSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int len = sourceArray.length;

        buildMaxHeap(sourceArray, len);

        for (int i = len - 1; i > 0; i--) {
            swap(sourceArray, 0, i);
            len--;
            heapify(sourceArray, 0, len);
        }
        return sourceArray;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
