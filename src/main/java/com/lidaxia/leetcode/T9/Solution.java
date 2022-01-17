package com.lidaxia.leetcode.T9;

/**
 * 9. 回文数
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/17 17:11（
 */
public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        int start = x;
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == start;
    }

    public static void main(String[] args) {
        isPalindrome(121);
    }

}
