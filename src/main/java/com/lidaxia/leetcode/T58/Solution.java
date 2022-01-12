package com.lidaxia.leetcode.T58;

/**
 * @author lidaxia
 * @desc
 * @date 2022/1/12 16:25（
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings != null && strings.length > 0) {
            return strings[strings.length - 1].length();
        }
        return 0;
    }
}
