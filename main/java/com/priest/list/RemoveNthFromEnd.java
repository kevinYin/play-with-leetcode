package com.priest.list;

import com.priest.common.ListNode;

/**
 * 详情 : 删除链表的倒数第N个节点
 * <p>
 * 详细 : https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author liangguanglong 2019/6/11
 */
public class RemoveNthFromEnd {

    /**
     * 思路：我们可以使用两个指针而不是一个指针。
     * 第一个指针从列表的开头向前移动 n+1n+1 步，而第二个指针将从列表的开头出发。
     * 现在，这两个指针被 nn 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，
     * 直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 n 个结点。
     * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode parentNode = new ListNode(1);
        parentNode.next = head;
        ListNode fastNode = parentNode;
        ListNode slowNode = parentNode;
        while (n >= 0) {
            fastNode = fastNode.next;
            n --;
        }
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return parentNode.next;
    }
}
