package com.lidaxia.segmenttree;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/27 21:24
 */
public interface Merger<E> {

    E merge(E a, E b);

}
