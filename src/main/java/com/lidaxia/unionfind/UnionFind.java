package com.lidaxia.unionfind;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/1 22:42
 */
public interface UnionFind {

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

    int getSize();

}
