package com.lidaxia.array;


/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/18 21:09
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数 传入数组的容量
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        this.data = (E[]) new Object[arr.length];
        this.size = arr.length;
        for (int i = 0; i < arr.length; i++)
            this.data[i] = arr[i];
    }

    /**
     * 获取数组中的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为0
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 数组最后添加元素
     *
     * @param value
     */
    public void addLast(E value) {
        add(size, value);
    }

    /**
     * 在第一个位置添加元素
     *
     * @param value
     */
    public void addFirsE(E value) {
        add(0, value);
    }

    /**
     * 在任意index 插入一个新元素
     *
     * @param index
     * @param value
     */
    public void add(int index, E value) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");

        if (size == data.length)
            resize(2 * data.length);


        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = value;
        size++;
    }

    /**
     * 原数组扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    /**
     * 获取指定位置元素数据
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index < size");

        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    /**
     * 更新指定位置元素
     *
     * @param index
     * @param value
     */
    public void set(int index, E value) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index < size");

        data[index] = value;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param value
     * @return
     */
    public boolean contains(E value) {
        for (int i = 0; i < size; i++)
            if (data[i] == value)
                return true;

        return false;
    }

    /**
     * 查找元素指定位置
     *
     * @param value
     * @return
     */
    public int find(E value) {
        for (int i = 0; i < size; i++)
            if (data[i] == value)
                return i;
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size");

        E result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        /**
         * 让垃圾回收 loitering objects
         */
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param value
     */
    public void removeElement(E value) {
        int index = find(value);
        if (index != -1)
            remove(index);
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d \n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
