package com.lidaxia.leetcode.T21;

/**
 * 21. 合并两个有序链表
 *
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/1 18:43
 */
class Solution {
    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoLists(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }

    /**
     * 虚拟头节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = solution.listNode(new int[]{1, 2, 4});
        System.out.println(listNode1);
    }

    private ListNode listNode(int[] arr) {

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i], new ListNode());
            cur = cur.next;
        }
        return dummyHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}