package com.lidaxia.leetcode.T5;

import sun.swing.StringUIClientPropertyKey;

/**
 * 5. 最长回文子串
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/7 17:16（
 */
public class Solution {

    /**
     * 暴力解法
     * O(n^3)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        /**
         * 记录起始位置 及最大长度
         */
        int maxLen = 1;
        int begin = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPaindromic(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private static boolean validPaindromic(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 中心扩展法
     * 时间复杂度O（n^2）,空间复杂度为O（1）
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {

        int begin = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            /**
             * 奇数 偶数 处理
             */
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int curMaxLen = Math.max(len1, len2);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(begin, begin + maxLen);

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
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;
        // dp[][] 表示s[i..j]是否是回文
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = true;

        char[] chars = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j])
                    dp[i][j] = false;
                else {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
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
        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());

        System.out.println(longestPalindrome1("abcd"));
        System.out.println(longestPalindrome2("abcd"));
    }
}