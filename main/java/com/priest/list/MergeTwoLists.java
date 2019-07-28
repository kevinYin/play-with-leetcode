package com.priest.list;

import com.priest.common.ListNode;

/**
 * 详情 : 合并两个有序链表
 * <p>
 * 详细 : https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 思路：创建一个新的链表，然后遍历，将每次比较最小的头结点放在新链表
 *
 * @author liangguanglong 2019/5/19
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (l1 != null && l2 != null) {
            if (l2.val >= l1.val) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            } else {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }
        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode n3 = new ListNode(3);
        node.next = n3;
        ListNode n5 = new ListNode(5);
        n3.next = n5;

        ListNode node2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        node2.next = n4;
        ListNode n6 = new ListNode(6);
        n4.next = n6;

        MergeTwoLists list = new MergeTwoLists();
        ListNode listNode = list.mergeTwoLists(node, node2);
        System.out.println(listNode);
    }
}
