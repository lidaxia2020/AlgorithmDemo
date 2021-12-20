package com.lidaxia.leetcode.T206;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/20 21:00
 */

import com.lidaxia.leetcode.T203.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 206. 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode res= null;
        while(head !=null){
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }

        return res;

    }
}