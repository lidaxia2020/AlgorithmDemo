package com.lidaxia.leetcode.T349;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集
 *
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/27 15:42
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums1)
            set.add(n);
        for (int n : nums2) {
            if (set.contains(n)) {
                list.add(n);
                set.remove(n);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;

    }
}