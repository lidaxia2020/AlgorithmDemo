package com.lidaxia.sort;

import java.util.Arrays;

/**
 * @author lidaxia
 * @desc
 * @date 2021/12/28 15:21（
 */
public class Sort {

    public static void main(String[] args) {
        int[] test = {6, 2, 1, 4, 3, 8, 9, 7};

        basal(test);

        for (int i : test)
            System.out.println(i);
    }

    /**
     * 直接插入排序
     * <p>
     * 核心思想: 插入排序通过构建有序序列，
     * 对于未排序数据，在已排序
     * 序列中从后向前扫描，找到
     * 相应位置并插入 ，如此重
     * 复，直至完成序列排序。
     *
     * @param array
     */
    public static void basal(int[] array) {
        if (array == null || array.length < 2)
            return;

        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            int j;
            for (j = i - 1; j >= 0 && cur < array[j]; j--) {
                //将较大元素后移
                array[j + 1] = array[j];
            }

            //temp插入正确的位置
            array[j + 1] = cur;
        }
    }

}
