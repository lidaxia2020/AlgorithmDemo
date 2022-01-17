package com.lidaxia.leetcode.T7;

/**
 * 7. 整数反转
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/17 17:07（
 */
public class Solution {

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

}


