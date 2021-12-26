package com.lidaxia.map;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/26 21:12
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();

}
