package com.lidaxia.segmenttree;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/27 21:27
 */
public class Main {

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums,
                (a, b) -> a + b);

        System.out.println(segmentTree);

        System.out.println(segmentTree.query(1, 2));
    }
}
