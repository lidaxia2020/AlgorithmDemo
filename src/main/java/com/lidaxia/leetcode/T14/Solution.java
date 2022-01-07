package com.lidaxia.leetcode.T14;

/**
 * 14. 最长公共前缀
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/7 17:02（
 */
public class Solution {

    /**
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        String str = strs[0];
        L:
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i))
                    break L;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    /**
     * 高效  使用startWith
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) return "";
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}