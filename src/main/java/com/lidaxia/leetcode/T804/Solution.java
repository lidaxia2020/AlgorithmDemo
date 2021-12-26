package com.lidaxia.leetcode.T804;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/26 20:48
 */
class Solution {
    /**
     * 804. 唯一摩尔斯密码词
     *
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        Set<String> result = new TreeSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
                sb.append(codes[word.charAt(i) - 'a']);
            result.add(sb.toString());
        }

        return result.size();


    }
}