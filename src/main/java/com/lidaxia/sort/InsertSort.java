package com.lidaxia.sort;

/**
 * 插入排序
 * 插入排序是一种最简单直观的排序算法，
 * 它的工作原理是通过构建有序序列，
 * 对于未排序数据，在已排序序列中从
 * 后向前扫描，找到相应位置并插入。
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/11 10:44（
 */
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        for (int i = 1; i < sourceArray.length; i++) {
            // 记录要插入的数据
            int temp = sourceArray[i];
            int j = i;
            while (j > 0 && temp < sourceArray[j - 1]) {
                sourceArray[j] = sourceArray[j - 1];
                j--;
            }

            if (j != i) {
                sourceArray[j] = temp;
            }

        }


        return sourceArray;
    }
}
