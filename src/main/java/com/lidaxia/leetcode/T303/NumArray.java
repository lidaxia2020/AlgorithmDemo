package com.lidaxia.leetcode.T303;

import com.lidaxia.segmenttree.SegmentTree;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/28 20:31
 */
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++)
                data[i] = nums[i];

            segmentTree = new SegmentTree<Integer>(data, ((a, b) -> a + b));
        }


    }

    public int sumRange(int left, int right) {
        if (segmentTree == null)
            throw new IllegalArgumentException("segmentTree is null");

        return segmentTree.query(left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */