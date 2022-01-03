package com.lidaxia.unionfind;

import java.util.Random;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/3 13:07
 */
public class Main {

    private static double testUf(UnionFind uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int size = 10000000;
        int m = 10000000;
        UnionFind1 unionFind1 = new UnionFind1(size);
        UnionFind2 unionFind2 = new UnionFind2(size);
        UnionFind3 unionFind3 = new UnionFind3(size);
        UnionFind4 unionFind4 = new UnionFind4(size);
        UnionFind5 unionFind5 = new UnionFind5(size);
        UnionFind6 unionFind6 = new UnionFind6(size);

//        System.out.println("UnionFind1 : " + testUf(unionFind1, m));
//
//        System.out.println("UnionFind2 : " + testUf(unionFind2, m));

        System.out.println("UnionFind3 : " + testUf(unionFind3, m));

        System.out.println("UnionFind4 : " + testUf(unionFind4, m));

        System.out.println("UnionFind5 : " + testUf(unionFind5, m));

        System.out.println("UnionFind6 : " + testUf(unionFind6, m));
    }
}
