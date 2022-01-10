package com.lidaxia.sort;

/**
 * 冒泡排序  O(n^2)
 * 它重复地走访过要排序的数列，一次比较两个元素，
 * 如果他们的顺序错误就把他们交换过来。走访数列的
 * 工作是重复地进行直到没有再需要交换，也就是说该
 * 数列已经排序完成。这个算法的名字由来是因为越小
 * 的元素会经由交换慢慢“浮”到数列的顶端
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/10 17:38（
 */
public class BubbleSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) {
        for (int i = 1; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray.length - i; j++) {
                if (sourceArray[j] > sourceArray[j + 1]) {
                    int temp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = temp;
                }
            }
        }

        return sourceArray;
    }
}
