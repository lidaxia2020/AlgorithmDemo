package com.lidaxia.hash;


import java.util.TreeMap;

/**
 * hash表: 均摊复杂度为O(1)
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/9 20:26
 */
public class HashTable<K, V> {

    /**
     * 扩容缩容 指标
     */
    private static final int upperTol = 10;
    private static final int lowerTol = 2;

    private static int capacityIndex = 0;

    private final int[] capacity = {53, 97, 193, 769, 1543, 3079, 6151, 12289, 24593,
            4917, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 500331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    public HashTable() {
        this.M = capacity[capacityIndex];
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++)
            hashTable[i] = new TreeMap<>();
    }


    public void add(K key, V value) {
        TreeMap<K, V> tempMap = hashTable[hash(key)];
        if (tempMap.containsKey(key))
            tempMap.put(key, value);
        else {
            tempMap.put(key, value);
            size++;

            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }

        }
    }

    /**
     * 容量改变
     *
     * @param newM
     */
    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++)
            newHashTable[i] = new TreeMap<>();

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            /**
             * hash 要采用新的值
             */
            for (K key : map.keySet())
                newHashTable[hash(key)].put(key, map.get(key));
        }

        this.hashTable = newHashTable;
    }

    public V remove(K key) {
        TreeMap<K, V> tempMap = hashTable[hash(key)];
        V ret = null;
        if (tempMap.containsKey(key)) {
            ret = tempMap.remove(key);
            size--;

            if (size < lowerTol * M && M / 2 > capacity[capacityIndex] && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }

        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> tempMap = hashTable[hash(key)];
        if (!tempMap.containsKey(key))
            throw new IllegalArgumentException(key + "doesn't exist!");
        tempMap.put(key, value);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsValue(key);
    }

    public int getSize() {
        return size;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
}
