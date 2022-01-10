package com.lidaxia.leetcode.T125;


/**
 * @author lidaxia
 * @desc
 * @date 2022/1/10 16:28（
 */
public class Solution {

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }

        if (str.length() <= 1)
            return true;


        s = str.toString();
        int len = s.length() / 2 + 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }

}
