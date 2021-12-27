package com.lidaxia.heap;

import com.lidaxia.array.Array;

/**
 * 基于数组实现的堆
 * 存储结构：最大堆/最小堆是一个 数组
 * 逻辑结构：最大堆/最小堆是一棵 完全二叉树
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/27 16:40
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        this.data = new Array<E>(arr);
        heapity();
    }

    /**
     * 将任意一个数组整理成堆  O(n)
     */
    public void heapity() {
        for (int i = parent(data.getSize() - 1); i >= 0; i--)
            siftDown(i);
    }


    /**
     * Sift up
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (isEmpty())
            throw new IllegalArgumentException("Can not findMax when heap is empty");

        return data.get(0);
    }

    /**
     * 取出堆中最大值
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        /**
         * 交换位置 并 删除
         */
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
                // data[j] 是左右孩子中的最大值
            }
            if (data.get(k).compareTo(data.get(j)) > 0)
                break;

            data.swap(k, j);
            k = j;
        }
    }


    /**
     * 取出堆中最大元素，并且替换成E
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E result = findMax();
        data.set(0, e);
        siftDown(0);
        return result;
    }


    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树中的父亲节点索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index=0 doesn't have parent.");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }


}
