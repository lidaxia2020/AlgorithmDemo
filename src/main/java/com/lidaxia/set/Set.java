package com.lidaxia.set;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/26 16:11
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
