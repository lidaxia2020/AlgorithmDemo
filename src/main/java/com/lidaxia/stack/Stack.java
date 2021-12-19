package com.lidaxia.stack;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/19 16:37
 */
public interface Stack<E> {

    /**
     * 存入元素
     * @param e
     */
    void push(E e);


    /**
     * 取出元素
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();

    /**
     * 获取size 大小
     * @return
     */
    int getSize();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

}
