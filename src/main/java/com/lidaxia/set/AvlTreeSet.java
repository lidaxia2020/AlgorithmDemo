package com.lidaxia.set;

import com.lidaxia.avltree.AvlTree;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/8 20:22
 */
public class AvlTreeSet<E extends Comparable<E>> implements Set<E> {

    private AvlTree<E, Object> avlTree;

    public AvlTreeSet() {
        this.avlTree = new AvlTree<>();
    }

    @Override
    public void add(E e) {
        avlTree.add(e, null);
    }

    @Override
    public void remove(E e) {
        avlTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avlTree.contains(e);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
