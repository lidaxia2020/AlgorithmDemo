package com.lidaxia.map;

import com.lidaxia.avltree.AvlTree;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/8 20:20
 */
public class AvlTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AvlTree<K, V> avl;

    public AvlTreeMap() {
        this.avl = new AvlTree<>();
    }

    @Override
    public void add(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avl.set(key, newValue);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
