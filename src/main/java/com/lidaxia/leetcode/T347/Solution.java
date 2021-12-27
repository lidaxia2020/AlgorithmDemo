package com.lidaxia.leetcode.T347;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 347. 前 K 个高频元素
 *
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/27 18:49
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        for (int num : nums) {
            if (treeMap.containsKey(num))
                treeMap.put(num, treeMap.get(num) + 1);
            else
                treeMap.put(num, 1);
        }

        /**
         * PriorityQueue 最小堆实现
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b)->treeMap.get(a)-treeMap.get(b)
        );
        for (Integer key : treeMap.keySet()) {
            if (pq.size() < k)
                pq.add(key);
            else if (treeMap.get(key) > treeMap.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        int[] result = new int[pq.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.remove();
        }

        return result;
    }

}
