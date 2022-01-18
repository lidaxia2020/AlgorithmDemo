package com.lidaxia.leetcode.T217;


import java.util.HashSet;

/**
 * 217. 存在重复元素
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/18 16:19（
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

}
