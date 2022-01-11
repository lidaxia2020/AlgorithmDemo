package com.lidaxia.sort;


/**
 * @author lidaxia
 * @desc
 * @date 2021/12/28 15:21（
 */
public class Sort {

    public static void main(String[] args) {
        int[] test = {6, 2, 1, 4, 3, 8, 9, 7};
        IArraySort bubbleSort = new MergeSort();
        test = bubbleSort.sort(test);

        for (int i : test)
            System.out.println(i);
    }


}
