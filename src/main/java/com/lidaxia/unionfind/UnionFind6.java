package com.lidaxia.unionfind;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/3 13:54
 */
public class UnionFind6 implements UnionFind {

    private int[] parent;
    /**
     * sz[i] 标识以i为根的集合中的元素个数
     */
    private int[] rank;


    public UnionFind6(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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
         * 根据2个元素所在树的rank不同判断合并方向
         * 将rank低的集合合并到rank高的集合上
         */
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
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

        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}




