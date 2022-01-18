package com.lidaxia.leetcode.T28;

/**
 * 28. 实现 strStr()
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/18 11:37（
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        return haystack.indexOf(needle);
    }
}
