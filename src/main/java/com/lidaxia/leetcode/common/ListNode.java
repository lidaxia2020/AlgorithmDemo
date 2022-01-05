package com.lidaxia.leetcode.common;

/**
 * @author lidaxia
 * @desc
 * @date 2022/1/5 16:38（
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode listNode(int[] nums) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }

        return head.next;
    }
}
