package com.priest.list;

import com.priest.common.ListNode;

import java.util.HashSet;

/**
 * 详情 : 142. 环形链表 II
 * <p>
 * 详细 : https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author liangguanglong 2019/6/16
 */
public class DetectCycle {

    //TODO  尚未解决
    public ListNode detectCycleWrong(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (slowNode != fastNode) {
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        DetectCycle cycle = new DetectCycle();
        ListNode node = cycle.detectCycle(node1);
        System.out.println(node);
        ListNode intersect = cycle.getIntersect(node1);
        System.out.println(intersect);
    }


}
