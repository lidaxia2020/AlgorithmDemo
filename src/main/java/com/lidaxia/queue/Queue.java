package com.lidaxia.queue;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/19 18:08
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
