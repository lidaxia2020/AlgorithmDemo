package com.lidaxia.leetcode.T5;

/**
 * 5. 最长回文子串
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/7 17:16（
 */
public class Solution {
    /**
     * 中心扩展法
     * 时间复杂度O（n^2）,空间复杂度为O（1）
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s.length() == 1)
            return s;

        /**
         * 加入  #
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");

        char[] shs = sb.toString().toCharArray();

        return "";

    }

    /**
     * 解法2（动态规划）
     * 时间复杂度O（n^2）,空间复杂度O（n^2）
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        return "";

    }

    /**
     * 解法3（Manacher）
     * 时间复杂度O（n）,空间复杂度O（n）
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {

        return "";

    }
}