package com.lidaxia.leetcode.T387;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/9 14:21
 */
public class Solution {

    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }

}
