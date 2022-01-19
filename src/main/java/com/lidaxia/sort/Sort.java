package com.lidaxia.sort;


/**
 * @author lidaxia
 * @desc
 * @date 2021/12/28 15:21（
 */
public class Sort implements IArraySort {

    public static void main(String[] args) {
        int[] test = {6, 2, 1, 4, 3, 8, 9, 7};
        IArraySort bubbleSort = new Sort();
        test = bubbleSort.sort(test);

        for (int i : test)
            System.out.println(i);
    }


    @Override
    public int[] sort(int[] sourceArray) {

        int[] temp = new int[sourceArray.length];
        sort(sourceArray, 0, sourceArray.length - 1, temp);

        return sourceArray;
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;

            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int s = left;
        int e = mid + 1;
        int i = 0;
        while (s <= mid && e <= right) {
            if (arr[s] < arr[e]) {
                temp[i++] = arr[s++];
            } else {
                temp[i++] = arr[e++];
            }
        }

        while (s <= mid) {
            temp[i++] = arr[s++];
        }
        while (e <= right) {
            temp[i++] = arr[e++];
        }

        i=0;
        while (left <= right) {
            arr[left++] = temp[i++];
        }
    }

}
