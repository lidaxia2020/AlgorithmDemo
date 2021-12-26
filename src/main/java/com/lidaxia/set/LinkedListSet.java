package com.lidaxia.set;

import com.lidaxia.linkedlist.LinkedList;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/26 16:28
 */
public class LinkedListSet<E> implements Set<E> {

   private LinkedList<E> linkedList;

    public LinkedListSet() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if ((linkedList.contains(e))){
            return;
        }

        linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
