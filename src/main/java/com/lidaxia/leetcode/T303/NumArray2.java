package com.lidaxia.leetcode.T303;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/28 20:41
 */
public class NumArray2 {

    private int[] sum;

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

    }


    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
