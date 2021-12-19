package com.lidaxia.stack;


import java.util.Stack;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/19 16:53
 */
public class Main {

    private static void testStack(com.lidaxia.stack.Stack stack) {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

    public static void main(String[] args) {
        testStack(new ArrayStack<>());

        testStack(new LinkListStack());
    }

    /**
     * 括号匹配
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar == '(') {
                    return false;
                } else if (c == ']' && topChar == '[') {
                    return false;
                } else if (c == '}' && topChar == '{') {
                    return false;
                }
            }
        }


        return stack.isEmpty();
    }
}
