package com.lidaxia.leetcode.T20;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/6 17:32（
 */
public class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) {
                stack.push(c);
                continue;
            }
            if (')' == c) {
                if (stack.isEmpty() ||'(' != stack.pop())
                    return false;
                continue;
            }

            if ('}'==c) {
                if (stack.isEmpty() ||'{'!=stack.pop())
                    return false;
                continue;
            }
            if (']' == c) {
                if (stack.isEmpty() ||'[' != stack.pop())
                    return false;
                continue;
            }

        }

        return stack.isEmpty();


    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
}
