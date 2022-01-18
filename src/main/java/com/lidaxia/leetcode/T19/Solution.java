package com.lidaxia.leetcode.T19;

import com.lidaxia.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/17 17:24（
 */
public class Solution {

    /**
     * map 存储
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        Map<Integer, ListNode> listNodeMap = new HashMap<>();
        int num = 0;
        ListNode temp = head;
        while (temp != null) {
            ListNode listNode = temp;

            listNodeMap.put(num++, listNode);
            temp = temp.next;
        }
        if (listNodeMap.size() == n) {
            return head.next;
        }

        ListNode t = listNodeMap.get(listNodeMap.size() - n - 1);
        t.next = t.next.next;
        return head;

    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dump = new ListNode(0, head);
        ListNode p = dump;
        ListNode q = dump;
        while (n > 0) {
            q = q.next;
            n--;
        }
        ListNode pre = null;
        while (q != null) {
            pre = p;
            p = p.next;
            q = q.next;
        }
        pre.next = pre.next.next;
        return dump.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.listNode(nums);
        removeNthFromEnd1(head, 2);
    }

}
