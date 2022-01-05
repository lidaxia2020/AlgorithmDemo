package com.lidaxia.leetcode.T61;

import com.lidaxia.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 61. 旋转链表
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/5 16:39（
 */
public class Solution {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) return head;

        //哈希索引存储
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int len = 1;
        //计算长度， 同时初始化哈希索引
        while (cur.next != null) {
            map.put(len++, cur);
            cur = cur.next;
        }

        //转n*len+k次，等价于转k%len次，k%len=0等价与0次翻转
        if ((k = (k % len)) == 0) return head;

        //形成环
        cur.next = head;

        //找到翻转后的尾结点
        ListNode newTail = map.get(len - k);

        //断开头尾
        ListNode newHead = newTail.next;
        newTail.next = null;

        //返回头节点
        return newHead;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.listNode(nums);

        rotateRight(listNode, 2);
    }

}
