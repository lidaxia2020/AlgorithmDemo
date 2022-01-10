package com.lidaxia.sort;

/**
 * 选择排序
 * 选择排序是一种简单直观的排序算法，
 * 无论什么数据进去都是 O(n²) 的时间复杂度。
 * 所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/10 17:50（
 */
public class SelectionSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {

        for (int i = 0; i < sourceArray.length; i++) {
            int temp = i;
            for (int j = i + 1; j < sourceArray.length; j++) {
                if (sourceArray[j] < sourceArray[temp])
                    temp = j;
            }

            if (i != temp){
                int t = sourceArray[i];
                sourceArray[i] = sourceArray[temp];
                sourceArray[temp] = t;
            }
        }

        return sourceArray;
    }
}
