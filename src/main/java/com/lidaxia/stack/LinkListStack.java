package com.lidaxia.stack;

import com.lidaxia.linkedlist.LinkedList;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/19 21:23
 */
public class LinkListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkListStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkListStack: top ");
        sb.append(list);
        return sb.toString();
    }
}
