package com.priest.list;

import com.priest.common.ListNode;

/**
 * 详情 : 移除链表元素
 * <p>
 * 详细 : https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author liangguanglong 2019/5/23
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {

        return head.val != val ? removeElements(head.next, val) : head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(6);
        ListNode head = new ListNode(1);
        head.next = node;
        RemoveElements removeElements = new RemoveElements();
        ListNode result = removeElements.removeElements(head, 6);
        System.out.println(result);
    }
}
