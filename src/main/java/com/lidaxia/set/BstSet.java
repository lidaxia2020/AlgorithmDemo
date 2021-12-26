package com.lidaxia.set;

import com.lidaxia.tree.Bst;

/**
 * 二分搜索树 实现set
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/26 16:12
 */
public class BstSet<E extends Comparable<E>> implements Set<E> {
    private Bst<E> bst;

    public BstSet() {
        this.bst = new Bst<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
