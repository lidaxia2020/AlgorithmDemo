package com.lidaxia.sort;


/**
 * 归并排序
 * 采用经典的分治（divide-and-conquer）策略
 * （分治法将问题分(divide)成一些小的问题然后
 * 递归求解，而治(conquer)的阶段则将分的阶段
 * 得到的各答案"修补"在一起，即分而治之)。
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/11 11:10（
 */
public class MergeSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[sourceArray.length];
        sort(sourceArray, 0, sourceArray.length - 1, temp);
        return sourceArray;
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边归并排序，使得左子序列有序
            sort(arr, left, mid, temp);
            //右边归并排序，使得右子序列有序
            sort(arr, mid + 1, right, temp);
            //将两个有序子数组合并操作
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid + 1;
        //临时数组指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
