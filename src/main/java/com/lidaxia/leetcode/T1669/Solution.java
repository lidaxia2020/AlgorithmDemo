package com.lidaxia.leetcode.T1669;

import com.lidaxia.leetcode.common.ListNode;

/**
 * 1669. 合并两个链表
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/6 15:32（
 */
public class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode cur = list1;
        ListNode pre = null;
        ListNode last = null;
        while (cur != null) {
            if (cur.next.val == a)
                pre = cur;
            if (cur.next.val == b) {
                last = cur.next.next;
                break;
            }
            cur = cur.next;
        }

        if (a == 0) {
            ListNode l = list2;
            while (l.next != null)
                l = l.next;
            l.next = last;

            return list2;
        } else {

            ListNode l = list2;
            while (l.next != null)
                l = l.next;
            pre.next = list2;
            l.next = last;
            return list1;
        }


    }

}
