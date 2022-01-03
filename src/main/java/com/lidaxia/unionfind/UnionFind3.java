package com.lidaxia.unionfind;

/**
 * 基于size优化
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/3 13:19
 */
public class UnionFind3 implements UnionFind {

    private int[] parent;
    /**
     * sz[i] 标识以i为根的集合中的元素个数
     */
    private int[] sz;


    public UnionFind3(int size) {
        this.parent = new int[size];
        this.sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }

    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;

        /**
         * 根据2个元素所在树的元素个数不同判断合并的方向
         * 将元素个数少的集合合并到元素个数多的集合上
         */
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    /**
     * 查找过程，查找元素p所对应的集合编号
     * O（h） 复杂度，h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");

        while (p != parent[p])
            p = parent[p];
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}

