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
    public static String longestPalindrome1(String s) {

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);

    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R - L - 1;
    }

    /**
     * 解法2（动态规划）
     * 时间复杂度O（n^2）,空间复杂度O（n^2）
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s.isEmpty())
            return "";

        int len = s.length();
        if (len == 1) return s;
        int longest = 1;
        int start = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i < len - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 1;
                    start = i;
                    longest = 2;
                }
            }
        }
        //子串长度
        for (int l = 3; l <= len; l++)
        {
            //枚举子串的起始点
            for (int i = 0; i + l - 1 < len; i++)
            {
                //终点
                int j = l + i - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    longest = l;
                }
            }
        }


        return s.substring(start, longest);

    }

    /**
     * 解法3（Manacher）
     * 时间复杂度O（n）,空间复杂度O（n）
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {

        return "";

    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome1("abcd"));
        System.out.println(longestPalindrome2("abcd"));
    }
}