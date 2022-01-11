package com.lidaxia.leetcode.T66;

/**
 * 66. 加一
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/11 17:31（
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        if (digits[0] == 9) {

        }

        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;

            } else {
                digits[i]++;
                break;
            }
        }
        // 首位是0  进行升级
        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[]a={1,2,3};
        a= new int[a.length+1];
        for (int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
