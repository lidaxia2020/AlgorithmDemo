package com.lidaxia.unionfind;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/1 22:49
 */
public class UnionFind1 implements UnionFind {
    private int[] id;

    public UnionFind1(int size) {
        this.id = new int[size];

        for (int i = 0; i < id.length; i++)
            id[i] = i;
    }

    /**
     * O(1)
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * O（n）
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pId)
                id[i] = qId;
    }

    private int find(int index) {
        if (index < 0 || index >= id.length)
            throw new IllegalArgumentException("index is out of bound");

        return id[index];
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
