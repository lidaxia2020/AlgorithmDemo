package com.lidaxia.leetcode.T307;

import com.lidaxia.segmenttree.SegmentTree;

/**
 * 307. 区域和检索 - 数组可修改
 *
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/28 20:49
 */
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++)
                data[i] = nums[i];
            segmentTree = new SegmentTree<>(data, (a, b) -> (a + b));
        }

    }

    public void update(int index, int val) {
        segmentTree.set(index, val);
    }

    public int sumRange(int left, int right) {
        if (segmentTree == null)
            throw new IllegalArgumentException("segmentTree is null;");
        return segmentTree.query(left, right);
    }


}
