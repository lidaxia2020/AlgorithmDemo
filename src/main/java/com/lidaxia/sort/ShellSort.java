package com.lidaxia.sort;

/**
 * 希尔排序
 * 基本思想是：先将整个待排序的记录序列分割成
 * 为若干子序列分别进行直接插入排序，待整个
 * 序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/11 10:56（
 */
public class ShellSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int gap = 1;
        while (gap < sourceArray.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < sourceArray.length; i++) {
                int tmp = sourceArray[i];
                int j = i - gap;
                while (j >= 0 && sourceArray[j] > tmp) {
                    sourceArray[j + gap] = sourceArray[j];
                    j -= gap;
                }
                sourceArray[j + gap] = tmp;
            }
            // Math.floor 返回不大于的最大整数
            gap = (int) Math.floor(gap / 3);
        }

        return sourceArray;
    }
}
