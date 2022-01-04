package com.lidaxia.leetcode.T27;


/**
 * 27. 移除元素
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/4 16:21（
 */
public class Solution {
    public static int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeElement(nums, val);
        System.out.println(len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }

}