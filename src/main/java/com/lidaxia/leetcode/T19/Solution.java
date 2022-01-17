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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        Map<Integer, ListNode> listNodeMap = new HashMap<>();
        int num = 0;
        ListNode temp = head;
        ListNode t = head;
        while (temp != null) {
            ListNode listNode =

            listNodeMap.put(num++, listNode.next);
            temp = temp.next;
        }

        return listNodeMap.get(listNodeMap.size() - n);

    }


}
