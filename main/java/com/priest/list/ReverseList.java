package com.priest.list;


import com.priest.common.ListNode;

/**
 * 详情 : 反转单向链表
 * <p>
 * 详细 : https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 思路 ：放一个中间节点作为记录当前反转的节点
 *
 * @author liangguanglong 2019/5/18
 */
public class ReverseList {


    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = null;
        while (secondNode != null ) {
            ListNode tmp = secondNode.next;
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = tmp;
        }

        return firstNode;
    }

    /**
     * 递归：
     *    https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     */
     public ListNode reverseList(ListNode head) {
         if (head == null || head.next == null) {
             return head;
         }
         ListNode p = reverseList(head.next);
         head.next.next = head;
         head.next = null;
         return p;
     }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode n2 = new ListNode(2);
        node.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;

        ReverseList list = new ReverseList();
        ListNode listNode = list.reverseList2(node);
        System.out.println(listNode);
    }
}
