package com.lidaxia.leetcode.T707;

/**
 * 707. 设计链表
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/6 15:55（
 */
public class MyLinkedList {

    private ListNode root;
    private int size;

    public MyLinkedList() {
        root = new ListNode();
        size = 0;
    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        ListNode cur = root;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;

        if (index < 0)
            index = 0;
        ListNode cur = root;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        ListNode listNode = new ListNode(val, cur.next);
        cur.next = listNode;
        size++;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        ListNode cur = root;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    private class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }
    }

}
